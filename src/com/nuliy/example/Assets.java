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
 *
 */
public class Assets {

    public static TextureAtlas atlas;
    public static TextureRegion stand;
    public static TextureRegion standGreen;
    public static TextureRegion standRed;
    public static TextureRegion standBlue;
    public static TextureRegion standOrange;
    public static TextureRegion standPurple;
    public static TextureRegion standGrey;
    public static TextureRegion deadGreen;
    public static TextureRegion deadBlue;
    public static TextureRegion deadGrey;
    public static TextureRegion deadOrange;
    public static TextureRegion deadPurple;
    public static TextureRegion deadRed;
          

    public static Animation runRight;
    public static Animation runGreen;
    public static Animation runRed;
    public static Animation runBlue;
    public static Animation runOrange;
    public static Animation runPurple;
    public static Animation runGrey;
    public static Animation DyingGreen;
    public static Animation DyingBlue;
    public static Animation DyingRed;
    public static Animation DyingOrange;
    public static Animation DyingPurple;
    public static Animation DyingGrey;
    
    
    public static Animation playerPunch90;
    public static Animation playerPunch180;
    public static Animation playerPunch270;
    public static Animation playerPunch360;

    public static void load() {
        atlas = new TextureAtlas("walking.pack");
        stand = atlas.findRegion("walking - 3");
        runRight = new Animation(1 / 11f,
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
        
      
        atlas = new TextureAtlas("PEDGreen.pack");
        standGreen = atlas.findRegion("walkingGreen - 3");
        runGreen = new Animation(1 / 8f,
                (atlas.findRegion("walkingGreen - 0.5")),
                (atlas.findRegion("walkingGreen - 1")),
                (atlas.findRegion("walkingGreen - 2")),
                (atlas.findRegion("walkingGreen - 2.5")),
                (atlas.findRegion("walkingGreen - 3")),
                (atlas.findRegion("walkingGreen - 3.5")),
                (atlas.findRegion("walkingGreen - 4")),
                (atlas.findRegion("walkingGreen - 5")),
                (atlas.findRegion("walkingGreen - 4")),
                (atlas.findRegion("walkingGreen - 3.5")),
                (atlas.findRegion("walkingGreen - 3")),
                (atlas.findRegion("walkingGreen - 2.5")),
                (atlas.findRegion("walkingGreen - 2")),
                (atlas.findRegion("walkingGreen - 1")),
                (atlas.findRegion("walkingGreen - 0.5")),
                (atlas.findRegion("walkingGreen - 2.5")),
                (atlas.findRegion("walkingGreen - 3")),
                (atlas.findRegion("walkingGreen - 3.5")),
                (atlas.findRegion("walkingGreen - 4")),
                (atlas.findRegion("walkingGreen - 5")),
                (atlas.findRegion("walkingGreen - 4")),
                (atlas.findRegion("walkingGreen - 3.5")),
                (atlas.findRegion("walkingGreen - 3")));

        atlas = new TextureAtlas("DEADGreen.pack");
        deadGreen = atlas.findRegion("DyingGreen-2");
        DyingGreen = new Animation(1 / 2f,
                (atlas.findRegion("DyingGreen1")),
                (atlas.findRegion("DyingGreen-2")));

        atlas = new TextureAtlas("PEDRed.pack");
        standRed = atlas.findRegion("walkingRed - 3");
        runRed = new Animation(1 / 8f,
                (atlas.findRegion("walkingRed - 0.5")),
                (atlas.findRegion("walkingRed - 1")),
                (atlas.findRegion("walkingRed - 2")),
                (atlas.findRegion("walkingRed - 2.5")),
                (atlas.findRegion("walkingRed - 3")),
                (atlas.findRegion("walkingRed - 3.5")),
                (atlas.findRegion("walkingRed - 4")),
                (atlas.findRegion("walkingRed - 5")),
                (atlas.findRegion("walkingRed - 4")),
                (atlas.findRegion("walkingRed - 3.5")),
                (atlas.findRegion("walkingRed - 3")),
                (atlas.findRegion("walkingRed - 2.5")),
                (atlas.findRegion("walkingRed - 2")),
                (atlas.findRegion("walkingRed - 1")),
                (atlas.findRegion("walkingRed - 0.5")),
                (atlas.findRegion("walkingRed - 2.5")),
                (atlas.findRegion("walkingRed - 3")),
                (atlas.findRegion("walkingRed - 3.5")),
                (atlas.findRegion("walkingRed - 4")),
                (atlas.findRegion("walkingRed - 5")),
                (atlas.findRegion("walkingRed - 4")),
                (atlas.findRegion("walkingRed - 3.5")),
                (atlas.findRegion("walkingRed - 3")));
        
        atlas = new TextureAtlas("DEADRed.pack");
        deadRed = atlas.findRegion("DyingRed2");
        DyingRed = new Animation(1 / 2f,
                (atlas.findRegion("DyingRed1")),
                (atlas.findRegion("DyingRed2")));

        atlas = new TextureAtlas("PEDBlue.pack");
        standBlue = atlas.findRegion("walkingBlue- 3");
        runBlue = new Animation(1 / 8f,
                (atlas.findRegion("walkingBlue - 0.5")),
                (atlas.findRegion("walkingBlue - 1")),
                (atlas.findRegion("walkingBlue - 2")),
                (atlas.findRegion("walkingBlue - 2.5")),
                (atlas.findRegion("walkingBlue- 3")),
                (atlas.findRegion("walkingBlue - 3.5")),
                (atlas.findRegion("walkingBlue - 4")),
                (atlas.findRegion("walkingBlue - 5")),
                (atlas.findRegion("walkingBlue - 4")),
                (atlas.findRegion("walkingBlue - 3.5")),
                (atlas.findRegion("walkingBlue- 3")),
                (atlas.findRegion("walkingBlue - 2.5")),
                (atlas.findRegion("walkingBlue - 2")),
                (atlas.findRegion("walkingBlue - 1")),
                (atlas.findRegion("walkingBlue - 0.5")),
                (atlas.findRegion("walkingBlue - 2.5")),
                (atlas.findRegion("walkingBlue- 3")),
                (atlas.findRegion("walkingBlue - 3.5")),
                (atlas.findRegion("walkingBlue - 4")),
                (atlas.findRegion("walkingBlue - 5")),
                (atlas.findRegion("walkingBlue - 4")),
                (atlas.findRegion("walkingBlue - 3.5")),
                (atlas.findRegion("walkingBlue- 3")));
        
        atlas = new TextureAtlas("DEADBlue.pack");
        deadBlue = atlas.findRegion("DyingBlue2");
        DyingBlue = new Animation(1 / 2f,
                (atlas.findRegion("DyingBlue1")),
                (atlas.findRegion("DyingBlue2")));

        atlas = new TextureAtlas("PEDOrange.pack");
        standOrange = atlas.findRegion("walkingOrange - 3");
        runOrange = new Animation(1 / 8f,
                (atlas.findRegion("walkingOrange - 0.5")),
                (atlas.findRegion("walkingOrange - 1")),
                (atlas.findRegion("walkingOrange - 2")),
                (atlas.findRegion("walkingOrange - 2.5")),
                (atlas.findRegion("walkingOrange - 3")),
                (atlas.findRegion("walkingOrange - 3.5")),
                (atlas.findRegion("walkingOrange - 4")),
                (atlas.findRegion("walkingOrange - 5")),
                (atlas.findRegion("walkingOrange - 4")),
                (atlas.findRegion("walkingOrange - 3.5")),
                (atlas.findRegion("walkingOrange - 3")),
                (atlas.findRegion("walkingOrange - 2.5")),
                (atlas.findRegion("walkingOrange - 2")),
                (atlas.findRegion("walkingOrange - 1")),
                (atlas.findRegion("walkingOrange - 0.5")),
                (atlas.findRegion("walkingOrange - 2.5")),
                (atlas.findRegion("walkingOrange - 3")),
                (atlas.findRegion("walkingOrange - 3.5")),
                (atlas.findRegion("walkingOrange - 4")),
                (atlas.findRegion("walkingOrange - 5")),
                (atlas.findRegion("walkingOrange - 4")),
                (atlas.findRegion("walkingOrange - 3.5")),
                (atlas.findRegion("walkingOrange - 3")));
        
         atlas = new TextureAtlas("DEADOrange.pack");
        deadOrange = atlas.findRegion("DyingOrange2");
        DyingOrange = new Animation(1 / 2f,
                (atlas.findRegion("DyingOrange1")),
                (atlas.findRegion("DyingOrange2")));

        atlas = new TextureAtlas("PEDPurple.pack");
        standPurple = atlas.findRegion("walkingPurple - 3");
        runPurple = new Animation(1 / 8f,
                (atlas.findRegion("walkingPurple - 0.5")),
                (atlas.findRegion("walkingPurple - 1")),
                (atlas.findRegion("walkingPurple - 2")),
                (atlas.findRegion("walkingPurple - 2.5")),
                (atlas.findRegion("walkingPurple - 3")),
                (atlas.findRegion("walkingPurple - 3.5")),
                (atlas.findRegion("walkingPurple - 4")),
                (atlas.findRegion("walkingPurple - 5")),
                (atlas.findRegion("walkingPurple - 4")),
                (atlas.findRegion("walkingPurple - 3.5")),
                (atlas.findRegion("walkingPurple - 3")),
                (atlas.findRegion("walkingPurple - 2.5")),
                (atlas.findRegion("walkingPurple - 2")),
                (atlas.findRegion("walkingPurple - 1")),
                (atlas.findRegion("walkingPurple - 0.5")),
                (atlas.findRegion("walkingPurple - 2.5")),
                (atlas.findRegion("walkingPurple - 3")),
                (atlas.findRegion("walkingPurple - 3.5")),
                (atlas.findRegion("walkingPurple - 4")),
                (atlas.findRegion("walkingPurple - 5")),
                (atlas.findRegion("walkingPurple - 4")),
                (atlas.findRegion("walkingPurple - 3.5")),
                (atlas.findRegion("walkingPurple - 3")));

        atlas = new TextureAtlas("DEADPurple.pack");
        deadPurple = atlas.findRegion("DyingPurple2");
        DyingPurple = new Animation(1 / 2f,
                (atlas.findRegion("DyingPurple1")),
                (atlas.findRegion("DyingPurple2")));

        atlas = new TextureAtlas("PEDGrey.pack");
        standGrey = atlas.findRegion("walkingGrey - 3");
        runGrey = new Animation(1 / 8f,
                (atlas.findRegion("walkingGrey - 0.5")),
                (atlas.findRegion("walkingGrey - 1")),
                (atlas.findRegion("walkingGrey - 2")),
                (atlas.findRegion("walkingGrey - 2.5")),
                (atlas.findRegion("walkingGrey - 3")),
                (atlas.findRegion("walkingGrey - 3.5")),
                (atlas.findRegion("walkingGrey - 4")),
                (atlas.findRegion("walkingGrey - 5")),
                (atlas.findRegion("walkingGrey - 4")),
                (atlas.findRegion("walkingGrey - 3.5")),
                (atlas.findRegion("walkingGrey - 3")),
                (atlas.findRegion("walkingGrey - 2.5")),
                (atlas.findRegion("walkingGrey - 2")),
                (atlas.findRegion("walkingGrey - 1")),
                (atlas.findRegion("walkingGrey - 0.5")),
                (atlas.findRegion("walkingGrey - 2.5")),
                (atlas.findRegion("walkingGrey - 3")),
                (atlas.findRegion("walkingGrey - 3.5")),
                (atlas.findRegion("walkingGrey - 4")),
                (atlas.findRegion("walkingGrey - 5")),
                (atlas.findRegion("walkingGrey - 4")),
                (atlas.findRegion("walkingGrey - 3.5")),
                (atlas.findRegion("walkingGrey - 3")));
        
        atlas = new TextureAtlas("DEADGrey.pack");
        deadGrey = atlas.findRegion("DyingGrey2");
        DyingGrey = new Animation(1 / 2f,
                (atlas.findRegion("DyingGrey1")),
                (atlas.findRegion("DyingGrey2")));


        atlas = new TextureAtlas("punch.pack");
        playerPunch90 = new Animation(1 / 11f,
                (atlas.findRegion("punch 1 90")),
                (atlas.findRegion("punch 2 90")),
                (atlas.findRegion("punch 3 90")),
                (atlas.findRegion("punch 4 90")),
                (atlas.findRegion("punch 3 90")),
                (atlas.findRegion("punch 2 90")),
                (atlas.findRegion("punch 1 90")));
        playerPunch180 = new Animation(1 / 11f,
                (atlas.findRegion("punch 1 180")),
                (atlas.findRegion("punch 2 180")),
                (atlas.findRegion("punch 3 180")),
                (atlas.findRegion("punch 4 180")),
                (atlas.findRegion("punch 3 180")),
                (atlas.findRegion("punch 2 180")),
                (atlas.findRegion("punch 1 180")));
        playerPunch270 = new Animation(1 / 11f,
                (atlas.findRegion("punch 1 270")),
                (atlas.findRegion("punch 2 270")),
                (atlas.findRegion("punch 3 270")),
                (atlas.findRegion("punch 4 270")),
                (atlas.findRegion("punch 3 270")),
                (atlas.findRegion("punch 2 270")),
                (atlas.findRegion("punch 1 270")));
        playerPunch360 = new Animation(1 / 11f,
                (atlas.findRegion("punch 1 360")),
                (atlas.findRegion("punch 2 360")),
                (atlas.findRegion("punch 3 360")),
                (atlas.findRegion("punch 4 360")),
                (atlas.findRegion("punch 3 360")),
                (atlas.findRegion("punch 2 360")),
                (atlas.findRegion("punch 1 360")));

    }

}
