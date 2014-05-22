/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuliy.example;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/** 
 *
 * @author yilun
 */
public class Pedestrian extends AI{

    private Rectangle bounds;
    private Vector2 velocity;
    private TextureRegion frame = Assets.stand;
    private float time = 0;
    private int AImovedecider;
    private int AImovetimer;
    private int health;

    public Pedestrian(float x, float y) {
        super(x,y);
    }
    
    public int getHP(){
        return health;
    }
    
    public void punched(){
        health -= 10;
    }
    
    public void shot(){
        health -= 20;
    }
}
