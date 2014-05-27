package com.nuliy.example;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 *
 * @author lamonta
 */
public class Assets {
    
    public static TextureAtlas atlas;
    public static TextureRegion stand;
    public static Animation runRight;
    
    public static void load()
    {
        atlas = new TextureAtlas("walking.pack");
        stand = atlas.findRegion("walking - 3");
        runRight = new Animation(1/11f,
                (atlas.findRegion("walking - 0.5")),
                (atlas.findRegion("walking - 1")),
                (atlas.findRegion("walking - 2")),
                (atlas.findRegion("walking - 2.5")),
                (atlas.findRegion("walking - 3")),
                (atlas.findRegion("walking - 3.5")),
                (atlas.findRegion("walking - 4")),
                (atlas.findRegion("walking - 5")),
                (atlas.findRegion("walking - 4")),
                (atlas.findRegion("walking - 3.5")),
                (atlas.findRegion("walking - 3")),
                (atlas.findRegion("walking - 2.5")),
                (atlas.findRegion("walking - 2")),
                (atlas.findRegion("walking - 1")),
                (atlas.findRegion("walking - 0.5")),
                (atlas.findRegion("walking - 2.5")),
                (atlas.findRegion("walking - 3")),
                (atlas.findRegion("walking - 3.5")),
                (atlas.findRegion("walking - 4")),
                (atlas.findRegion("walking - 5")),
                (atlas.findRegion("walking - 4")),
                (atlas.findRegion("walking - 3.5")),
                (atlas.findRegion("walking - 3")));
        
        
    }
    
}