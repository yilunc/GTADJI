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
    public static Animation playerPunch90;
    public static Animation playerPunch180;
    public static Animation playerPunch270;
    public static Animation playerPunch360;
    
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
        
        atlas = new TextureAtlas("punch.pack");
        playerPunch90 = new Animation(1/11f,
                (atlas.findRegion("punch 1 90")),
                (atlas.findRegion("punch 2 90")),
                (atlas.findRegion("punch 3 90")),
                (atlas.findRegion("punch 4 90")),
                (atlas.findRegion("punch 3 90")),
                (atlas.findRegion("punch 2 90")),
                (atlas.findRegion("punch 1 90")));
        playerPunch180 = new Animation(1/11f,
                (atlas.findRegion("punch 1 180")),
                (atlas.findRegion("punch 2 180")),
                (atlas.findRegion("punch 3 180")),
                (atlas.findRegion("punch 4 180")),
                (atlas.findRegion("punch 3 180")),
                (atlas.findRegion("punch 2 180")),
                (atlas.findRegion("punch 1 180")));
        playerPunch270 = new Animation(1/11f,
                (atlas.findRegion("punch 1 270")),
                (atlas.findRegion("punch 2 270")),
                (atlas.findRegion("punch 3 270")),
                (atlas.findRegion("punch 4 270")),
                (atlas.findRegion("punch 3 270")),
                (atlas.findRegion("punch 2 270")),
                (atlas.findRegion("punch 1 270")));
        playerPunch360 = new Animation(1/11f,
                (atlas.findRegion("punch 1 360")),
                (atlas.findRegion("punch 2 360")),
                (atlas.findRegion("punch 3 360")),
                (atlas.findRegion("punch 4 360")),
                (atlas.findRegion("punch 3 360")),
                (atlas.findRegion("punch 2 360")),
                (atlas.findRegion("punch 1 360")));
        
    }
    
}