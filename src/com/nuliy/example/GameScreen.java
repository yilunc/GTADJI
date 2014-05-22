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

    private OrthographicCamera cam;

    private Vector3 touched = new Vector3(0, 0, 0);
    private Vector3 mouse = new Vector3(0, 0, 0);
    private Vector3 exactMove = new Vector3(0, 0, 0);
    private Player p;
    private Pedestrian[] Peds;

    private int camx = 0;
    private int camy = 0;
    private float x;
    private float y;
    private int playerSpeed = 150;
    private int AIspeed = 75;
    private int AIscaredtimer = 0;
    private boolean AIisscared = false;
    int mapWidth, mapHeight, tilePixelWidth, tilePixelHeight;

    int mapPixelWidth, mapPixelHeight;

    private Game game;

    public TiledMap map;
    private OrthogonalTiledMapRenderer mapRender;

    public GameScreen(Game game) {
        this.game = game;
        map = new TmxMapLoader().load("map.tmx");
        mapRender = new OrthogonalTiledMapRenderer(map);
        MapProperties prop = map.getProperties();

        mapWidth = prop.get("width", Integer.class);
        mapHeight = prop.get("height", Integer.class);
        tilePixelWidth = prop.get("tilewidth", Integer.class);
        tilePixelHeight = prop.get("tileheight", Integer.class);

        mapPixelWidth = (mapWidth - 2) * tilePixelWidth - 16;
        mapPixelHeight = (mapHeight - 2) * tilePixelHeight;

        Peds = new Pedestrian[30];
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mouse.x = Gdx.input.getX();
        mouse.y = Gdx.input.getY();
        cam.unproject(mouse);

        //aim the player at where the screen has been touched
        if (Gdx.input.isTouched()) {
            touched.x = Gdx.input.getX();
            touched.y = Gdx.input.getY();
            cam.unproject(touched);

            p.mouseAngle(touched.x, touched.y);
        }

        //player movement arguments
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

        //make the Ai scared ans run away from the player
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            AIscaredtimer = 200;
        }

        if (AIscaredtimer > 0) {
            AIisscared = true;
            AIscaredtimer--;
        } else {
            AIisscared = false;
        }

        for (Pedestrian AI1 : Peds) {
            if (AI1 != null && AIisscared == false) {
                AI1.move(75);
            } else if (AI1 != null && AIisscared == true) {
                AI1.scared(p, 75 * 2);
            }
        }
        for (Pedestrian Ped : Peds) {
            Ped.update(delta);
        }

        // update player
        p.update(delta);
        for (Pedestrian Ped : Peds) {
            if (Ped != null && p.getBounds().overlaps(Ped.getBounds())) {
                Ped.handleCollision(p.getBounds());
            }
        }

        for (int h = 0; h < Peds.length; h++) {
            for (int i = 0; i < Peds.length; i++) {
                if (i != h && Peds[h] != null && Peds[h].getBounds().overlaps(Peds[i].getBounds())) {
                    Peds[h].handleCollision(Peds[i].getBounds());
                }
            }
        }

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

        cam.position.set(camx, camy, 0);
        cam.update();

        mapRender.setView(cam);
        mapRender.render();

        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        for (Pedestrian AI1 : Peds) {
            if (AI1 != null) {
                AI1.draw(batch, "P");
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            p.draw(batch);
        } else {
            p.draw(batch);
        }

//        for (int h = 0; h < AI.length; h++) {
//            for (int i = 0; i < AI.length; i++) {
//                if (i != h && AI[h] != null && AI[h].getBounds().overlaps(AI[i].getBounds())) {
//                    if (p.getY() > AI[i].getY() && p.getY() > AI[h].getY() && AI[i].getY() > AI[h].getY()) {
//                        p.draw(batch);
//                        AI[i].draw(batch);
//                        AI[h].draw(batch);
//                    } else if (p.getY() < AI[i].getY() && p.getY() > AI[h].getY() && AI[i].getY() > AI[h].getY()) {
//                        AI[i].draw(batch);
//                        p.draw(batch);
//                        AI[h].draw(batch);
//                    } else if (p.getY() < AI[i].getY() && p.getY() < AI[h].getY() && AI[i].getY() > AI[h].getY()) {
//                        AI[i].draw(batch);
//                        AI[h].draw(batch);
//                        p.draw(batch);
//                    } else if (p.getY() > AI[i].getY() && p.getY() > AI[h].getY() && AI[i].getY() < AI[h].getY()) {
//                        AI[h].draw(batch);
//                        AI[i].draw(batch);
//                        p.draw(batch);
//                    } else if (p.getY() > AI[i].getY() && p.getY() < AI[h].getY() && AI[i].getY() < AI[h].getY()) {
//                        AI[h].draw(batch);
//                        p.draw(batch);
//                        AI[i].draw(batch);
//                    } else if (p.getY() < AI[i].getY() && p.getY() < AI[h].getY() && AI[i].getY() < AI[h].getY()) {
//                        AI[h].draw(batch);
//                        AI[i].draw(batch);
//                        p.draw(batch);
//                    }
//                }
//            }
//        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();

        Assets.load();

        p = new Player(200.0f, 300.0f);

        for (int i = 0; i < Peds.length; i++) {
            if (Peds[i] == null) {
                Peds[i] = new Pedestrian((float) Math.random() * 1000, (float) Math.random() * 1000);
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
