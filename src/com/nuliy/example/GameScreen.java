/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuliy.example;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.math.Vector3;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

public class GameScreen implements Screen {

    private SpriteBatch batch, batchMiniMap;

    private OrthographicCamera camPlayer, camMiniMap, UI;

    private Texture playermarker;
    private Texture healthbar;
    private Texture HUDfist;
    private Texture HUDm4;
    private Vector3 touched = new Vector3(0, 0, 0);
    private Vector3 mouse = new Vector3(0, 0, 0);
    private Vector3 exactMove = new Vector3(0, 0, 0);
    private Player p;
    private Pedestrian[] Peds;
    private DeadPed[] deadPeds;
    private Police[] police;
    private Scoreboard playerScore;
    private MapObjects objects;

    private int camx = 0;
    private int camy = 0;
    private float x;
    private float y;
    private int playerSpeed = 160;
    private int AIspeed = 75;
    private int AIscaredtimer = 0;
    private int ogNumDeadPeds = 30;
    private int numDeadPeds = ogNumDeadPeds;
    private boolean AIisscared = false;
    private int mapWidth, mapHeight, tilePixelWidth, tilePixelHeight;
    private boolean isClicked, isHeldDown, isQDown, isQHeld;
    private BitmapFont font = new BitmapFont();
    private ShapeRenderer shaperenderer = new ShapeRenderer();

    int mapPixelWidth, mapPixelHeight;

    private Game game;

    public TiledMap map, miniMap;
    private OrthogonalTiledMapRenderer mapRender, miniMapRender;

    public GameScreen(Game game) {
        this.game = game;
        map = new TmxMapLoader().load("GTA MAP.tmx");
        mapRender = new OrthogonalTiledMapRenderer(map);
        miniMap = new TmxMapLoader().load("GTA MAP.tmx");
        miniMapRender = new OrthogonalTiledMapRenderer(map);
        playermarker = new Texture(Gdx.files.internal("playermarkercircle.png"));
        healthbar = new Texture(Gdx.files.internal("healthbar.png"));
        HUDfist = new Texture(Gdx.files.internal("fist.png"));
        HUDm4 = new Texture(Gdx.files.internal("m4.png"));
        playerScore = new Scoreboard();
        MapProperties prop = map.getProperties();

        mapWidth = prop.get("width", Integer.class);
        mapHeight = prop.get("height", Integer.class);
        tilePixelWidth = prop.get("tilewidth", Integer.class);
        tilePixelHeight = prop.get("tileheight", Integer.class);

        mapPixelWidth = (mapWidth - 2) * tilePixelWidth - 16;
        mapPixelHeight = (mapHeight - 2) * tilePixelHeight;

        font.scale(0.4f);

        Peds = new Pedestrian[200];
        deadPeds = new DeadPed[numDeadPeds];
        police = new Police[10];
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //aim the player at where the screen has been touched
        if (Gdx.input.isTouched()) {
            p.mouseAngle(touched.x, touched.y);
            touched.x = Gdx.input.getX();
            touched.y = Gdx.input.getY();
            if (isHeldDown == false) {
                isClicked = true;
            }
            camPlayer.unproject(touched);
            isHeldDown = true;
        } else {
            isHeldDown = false;
        }

        //player running
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            playerSpeed = 300;
        } else {
            playerSpeed = 160;
        }

        //player weapon switching
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            if (isQHeld == false) {
                isQDown = true;
                System.out.println(isQDown);
            }
            isQHeld = true;
        } else {
            isQHeld = false;
        }
        if (isQDown == true) {
            p.rotateWeps();
            isQDown = false;
        }

        //player movements
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            p.setDX(playerSpeed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            p.setDX(-playerSpeed);
        } else {
            p.setDX(0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            p.setDY(playerSpeed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            p.setDY(-playerSpeed);
        } else {
            p.setDY(0);
        }

        //make the Ai scared and run away from the player
        //player punching
        if (p.getGunID() == 0 && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            p.angleRound();
            p.punch();
        } else {
            p.stopPunch();
        }
        for (Pedestrian AI1 : Peds) {
            if (AI1 != null && p.getGunID() == 0 && (Gdx.input.isKeyPressed(Input.Keys.SPACE) || (p.getGunID() == 1 && isClicked == true))) {
                AIscaredtimer = 200;
            }
        }
        if (AIscaredtimer > 0) {
            AIisscared = true;
            AIscaredtimer--;
        } else {
            AIisscared = false;
        }

        //move all the AI
        for (Pedestrian AI1 : Peds) {
            if (AI1 != null && AIisscared == false) {
                AI1.move(75);
            } else if (AI1 != null && AIisscared == true && AI1.distanceFrom(p) < 200) {
                AI1.scared(p, 75 * 2);
            }
        }
        
        //move all police
        for (Police cop : police){
            if (p.getWantedLvl() >= 100 && cop.distanceFrom(p) > 200){
                cop.setLastRot(p);
                cop.chase(p);
            }else if (p.getWantedLvl() >= 100 && cop.distanceFrom(p) < 200){
                        System.out.println("shot");
                cop.stop();
                cop.setLastRot(p);
                cop.shootPlayer(p);
                p.isDead();
            }else {
                cop.move(AIspeed);
            }
        }

        //player decrease wanted level if less than three stars wanted
        p.wantedLvlDecrease();
        
        //player regen health
        p.regenHealth();

        //player shoot M4
        //pedestrians and police getting shot
        if (isClicked == true && p.getGunID() == 1) {
            p.shootM4();
            for (Pedestrian Ped : Peds) {
                AIscaredtimer = 200;
                if (Ped != null && Ped.getBounds().contains(touched.x, touched.y)) {
                    Ped.shot();
                    Ped.isDead();
                    System.out.println("shot");
                }
            }
            for (Police cop : police) {
                AIscaredtimer = 200;
                if (cop != null && cop.getBounds().contains(touched.x, touched.y)) {
                    cop.shot();
                    cop.isDead();
                    System.out.println("shot");
                }
            }
            isClicked = false;
        } else {
            p.stopShootM4();
        }

        //map collisions
        objects = map.getLayers().get("Object Layer 1").getObjects();

        for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = rectangleObject.getRectangle();
            if (Intersector.overlaps(rectangle, p.getBounds())) {
                p.handleCollision(rectangle);
            }
            for (Pedestrian AI1 : Peds) {
                if (AI1 != null && Intersector.overlaps(rectangle, AI1.getBounds())) {
                    AI1.handleCollision(rectangle);
                }
            }
            for (Police cop: police) {
                if (cop != null && Intersector.overlaps(rectangle, cop.getBounds())) {
                    cop.handleCollision(rectangle);
                }
            }
        }

        //pedestrians getting punched
        for (Pedestrian Ped : Peds) {
            if (Ped != null && p.getBounds().overlaps(Ped.getBounds())) {
                p.handleCollision(Ped.getBounds());
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                    Ped.punched();
                }
            }
        }
        
        //cops getting punched
        for (Police cop : police) {
            if (cop != null && p.getBounds().overlaps(cop.getBounds())) {
                p.handleCollision(cop.getBounds());
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                    cop.punched();
                }
            }
        }

        //pedestrains get killed once in the water
        for (int i = 0; i < Peds.length; i ++) {
            if (Peds[i] != null && ((Peds[i].getX() > (mapPixelWidth - 200)) || (Peds[i].getX() < 230) || (Peds[i].getY() > (mapPixelHeight - 200)) || Peds[i].getY() < 200)) {
                Peds[i] = null;
            }
        }
        
        //police get killed once in the water
        for (int i = 0; i < police.length; i ++) {
            if (police[i] != null && ((police[i].getX() > (mapPixelWidth - 200)) || (police[i].getX() < 230) || (police[i].getY() > (mapPixelHeight - 200)) || police[i].getY() < 200)) {
                police[i] = null;
            }
        }

        //collision between pedestrians
        for (int h = 0; h < Peds.length; h++) {
            for (int i = 0; i < Peds.length; i++) {
                if (i != h && Peds[h] != null && Peds[i] != null && Peds[h].getBounds().overlaps(Peds[i].getBounds())) {
                    Peds[h].handleCollision(Peds[i].getBounds());
                }
            }
        }
        //collision between police
        for (int h = 0; h < police.length; h++) {
            for (int i = 0; i < police.length; i++) {
                if (i != h && police[h] != null && police[i] != null && police[h].getBounds().overlaps(police[i].getBounds())) {
                    police[h].handleCollision(police[i].getBounds());
                }
            }
        }

        //pedestrians dying
        for (int i = 0; i < Peds.length; i++) {
            if (Peds[i] != null) {
                if (Peds[i].isDead() == true) {
                    numDeadPeds = (numDeadPeds + 1) % (ogNumDeadPeds);
                    deadPeds[numDeadPeds] = new DeadPed(Peds[i].getX(), Peds[i].getY(), Peds[i].getLastRot(), Peds[i].getColor());
                    p.wantedKilledPed();
                    playerScore.addScoreKilledPed(p);
                    Peds[i] = null;
                }
            }
        }

        //camera positioning
        if (p.getX() - Gdx.graphics.getWidth() / 2 - tilePixelWidth * 2 - 16 > 0 && p.getX() + Gdx.graphics.getWidth() / 2 < mapPixelWidth) {
            camx = (int) p.getX();
        } else if (p.getX() - Gdx.graphics.getWidth() / 2 - tilePixelWidth * 2 - 16 <= 0) {
            camx = Gdx.graphics.getWidth() / 2 + tilePixelWidth * 2 + 16;
        } else if (p.getX() + Gdx.graphics.getWidth() / 2 >= mapPixelWidth) {
            camx = mapPixelWidth - Gdx.graphics.getWidth() / 2;
        }
        if (p.getY() - Gdx.graphics.getHeight() / 2 - tilePixelHeight * 2 > 0 && p.getY() + Gdx.graphics.getHeight() / 2 < mapPixelHeight) {
            camy = (int) p.getY();
        } else if (p.getY() - Gdx.graphics.getHeight() / 2 - tilePixelHeight * 2 <= 0) {
            camy = Gdx.graphics.getHeight() / 2 + tilePixelWidth * 2;
        } else if (p.getY() + Gdx.graphics.getHeight() / 2 >= mapPixelHeight) {
            camy = mapPixelHeight - Gdx.graphics.getHeight() / 2;
        }

        camPlayer.position.set(camx, camy, 0);
        camPlayer.update();
        camMiniMap.update();

        mapRender.setView(camPlayer);
        mapRender.render();

        batch.setProjectionMatrix(camPlayer.combined);
        batch.begin();

        //draw dead people
        for (DeadPed dPed : deadPeds) {
            if (dPed != null) {
                dPed.drawDead(batch, delta);
            }
        }
        
        //update positions of characters
        for (Pedestrian Ped : Peds) {
            if (Ped != null) {
                Ped.update(delta);
            }
        }
        for (Police cop : police){
            if (cop != null){
                cop.update(delta);
            }
        }
        //Update position of player
        p.update(delta);

        //draw characters
        for (Pedestrian AI1 : Peds) {
            if (AI1 != null) {
                AI1.draw(batch, AI1.getColor());
            }
        }
        for (Police cop : police){
            if (cop != null){
                cop.draw(batch, p, delta);
            }
        }

        //respawn a new pedestrian if they are dead
        for (int i = 0; i < Peds.length; i++) {
            if (Peds[i] == null) {
                Peds[i] = new Pedestrian((float) Math.random() * 4000 + 1000, (float) Math.random() * 4000 + 1000, (int) (Math.random() * 6 + 1));
            }
        }
         //respawn a new cop if they are dead
        for (int i = 0; i < police.length; i++) {
            if (police[i] == null) {
                police[i] = new Police((float) Math.random() * 4000 + 1000, (float) Math.random() * 4000 + 1000);
            }
        }

        //draw player
        p.draw(batch, delta);

        batch.end();

        //HUD Rendering
        batchMiniMap.setProjectionMatrix(camMiniMap.combined);
        miniMapRender.setView(camMiniMap);
        miniMapRender.render();
        batchMiniMap.begin();

        batchMiniMap.draw(playermarker, p.getX() - (playermarker.getWidth() / 2), p.getY() - (playermarker.getHeight() / 2));
        for (Pedestrian AI : Peds) {
            if (AI != null) {
                AI.draw(batchMiniMap, 1);
            }
        }

        batchMiniMap.end();

        batch.setProjectionMatrix(UI.combined);

        batch.begin();

        font.draw(batch, "Health: " + (int) p.getHealth() / 2, 685, 520);
        font.draw(batch, "Score: " + playerScore.returnScore(), 685, 500);
        font.draw(batch, "Multiplier: x" + (int) ((Math.ceil(p.getWantedLvl() / 100)) + 1), 685, 480);
        if (p.getWantedLvl() >= 100) {
            font.draw(batch, "Wanted: " + (int) (Math.ceil((int) p.getWantedLvl() / 100)), 685, 460);
        }
        if (p.getGunID() == 0) {
            batch.draw(HUDfist, 712, 533, 50, 50);
        } else if (p.getGunID() == 1) {
            batch.draw(HUDm4, 687, 530, 100, 50);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        camPlayer = new OrthographicCamera();
        camPlayer.setToOrtho(false, 800, 600);
        UI = new OrthographicCamera();
        UI.setToOrtho(false, 800, 600);
        camMiniMap = new OrthographicCamera(800, 600);
        camMiniMap.zoom = 30f;

        batch = new SpriteBatch();
        batchMiniMap = new SpriteBatch();

        camMiniMap.position.set(12000, 9000, 0);

        Assets.load();

        p = new Player(200.0f, 300.0f);

        for (int i = 0; i < Peds.length; i++) {
            if (Peds[i] == null) {
                Peds[i] = new Pedestrian((float) Math.random() * 4000 + 1000, (float) Math.random() * 4000 + 1000, (int) (Math.random() * 6 + 1));
            }
        }

        for (int i = 0; i < police.length; i++) {
            if (police[i] == null) {
                police[i] = new Police((float) Math.random() * 4000 + 1000, (float) Math.random() * 4000 + 1000);
            }
        }
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
