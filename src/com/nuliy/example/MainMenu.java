/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nuliy.example;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 *
 * @author muirj0095
 */
public class MainMenu implements Screen{
    
    private SpriteBatch batch;
    private Texture splash;
    private Game game;
    
    public MainMenu (Game game)
    {
        this.game = game;
    }
    
    @Override
    public void render(float delta) {
        //how to change to game screen
        if (Gdx.input.isTouched())
        {
            game.setScreen(new GameScreen(game));
        }
        //drawing start screen
        batch.begin();
        batch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }
    @Override
    public void resize(int width, int height) {

    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        splash = new Texture ("splash.png");
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