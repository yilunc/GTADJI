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
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {

    private SpriteBatch batch;

    private OrthographicCamera camPlayer, camMap;

    private Vector3 touched = new Vector3(0, 0, 0);
    private Vector3 mouse = new Vector3(0, 0, 0);
    private Vector3 exactMove = new Vector3(0, 0, 0);
    private Player p;
    private Pedestrian[] Peds;
    private DeadPed[] deadPeds;

    private int camx = 0;
    private int camy = 0;
    private float x;
    private float y;
    private int playerSpeed = 160;
    private int AIspeed = 75;
    private int AIscaredtimer = 0;
    private boolean AIisscared = false;
    int mapWidth, mapHeight, tilePixelWidth, tilePixelHeight;

    int mapPixelWidth, mapPixelHeight;

    private Game game;

    public TiledMap map;
    private OrthogonalTiledMapRenderer mapRender, miniMapRender;

    public GameScreen(Game game) {
        this.game = game;
        map = new TmxMapLoader().load("GTA MAP.tmx");
        mapRender = new OrthogonalTiledMapRenderer(map);
        miniMapRender = new OrthogonalTiledMapRenderer(map);
        MapProperties prop = map.getProperties();

        mapWidth = prop.get("width", Integer.class);
        mapHeight = prop.get("height", Integer.class);
        tilePixelWidth = prop.get("tilewidth", Integer.class);
        tilePixelHeight = prop.get("tileheight", Integer.class);

        mapPixelWidth = (mapWidth - 2) * tilePixelWidth - 16;
        mapPixelHeight = (mapHeight - 2) * tilePixelHeight;

        Peds = new Pedestrian[300];
        deadPeds = new DeadPed[25];
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //aim the player at where the screen has been touched
        touched.x = Gdx.input.getX();
        touched.y = Gdx.input.getY();
        camPlayer.unproject(touched);

        if (Gdx.input.isTouched()) {
            p.mouseAngle(touched.x, touched.y);

        }

        //player movement arguments
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            playerSpeed = 250;
        } else {
            playerSpeed = 160;
        }
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
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            AIscaredtimer = 200;
            p.angleRound();
            p.punch();
        } else {
            p.stopPunch();

        }

        for (Pedestrian AI1 : Peds) {
            if (AI1 != null && AIscaredtimer <= 0) {
                AI1.move(75);
            } else if (AI1 != null && AIscaredtimer > 0) {
                AI1.scared(p, 75 * 2);
            }
        }

        //update positions of characters
        for (Pedestrian Ped : Peds) {
            if (Ped != null) {
                Ped.update(delta);
            }
        }
        p.update(delta);

        //collisions with player and pedestrians
        for (int i = 0; i < Peds.length; i++) {
            if (Peds[i] != null && p.getBounds().overlaps(Peds[i].getBounds())) {
                Peds[i].handleCollision(p.getBounds());
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                    Peds[i].punched();
                    if (Peds[i].isDead() == true) {
                        System.out.println(Peds[i].isDead());
                        
                        Peds[i] = null;
                    }
                }
            }
        }

        for (Pedestrian AI1 : Peds) {
            if (AI1 != null && AIisscared == false) {
                AI1.move(75);
            } else if (AI1 != null && AIisscared == true) {
                AI1.scared(p, 75);
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
        camMap.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        camMap.update();
        camMap.zoom = 1.0f;

        miniMapRender.setView(camMap);
        miniMapRender.render();

        mapRender.setView(camPlayer);
        mapRender.render();

        batch.setProjectionMatrix(camPlayer.combined);
        batch.begin();

        //draw pedestrians
        for (Pedestrian AI1 : Peds) {
            if (AI1 != null) {
                AI1.draw(batch, AI1.getColor());
            }
        }

        //draw player
        p.draw(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        camPlayer = new OrthographicCamera();
        camPlayer.setToOrtho(false, 800, 600);
        camMap = new OrthographicCamera();
        camMap.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();

        Assets.load();

        p = new Player(200.0f, 300.0f);

        for (int i = 0; i < Peds.length; i++) {
            if (Peds[i] == null) {
                Peds[i] = new Pedestrian((float) Math.random() * 1000, (float) Math.random() * 1000, (int) (Math.random() * (6 + 1)));
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
