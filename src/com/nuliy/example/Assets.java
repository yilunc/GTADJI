package com.nuliy.example;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
    public static TextureRegion standCop;
    public static TextureRegion deadGreen;
    public static TextureRegion deadGrey;
    public static TextureRegion deadRed;
    public static TextureRegion deadBlue;
    public static TextureRegion deadOrange;
    public static TextureRegion deadPurple;
    public static TextureRegion deadCop;
    public static TextureRegion dead;
    public static TextureRegion shootM4;
    public static TextureRegion flashM4;
    public static TextureRegion healthbar;
    public static Texture car;

    public static Animation runRight;
    public static Animation sprintRight;
    public static Animation runGreen;
    public static Animation runRed;
    public static Animation runBlue;
    public static Animation runOrange;
    public static Animation runPurple;
    public static Animation runGrey;
    public static Animation runCop;
    public static Animation dyingGreen;
    public static Animation dyingRed;
    public static Animation dyingBlue;
    public static Animation dyingOrange;
    public static Animation dyingPurple;
    public static Animation dyingGrey;
    public static Animation dyingCop;
    public static Animation dying;

    public static Animation playerPunch90;
    public static Animation playerPunch180;
    public static Animation playerPunch270;
    public static Animation playerPunch360;

    public static void load() {
        
        car = new Texture(Gdx.files.internal("Car.png"));
        
        atlas = new TextureAtlas("walking.pack");
        stand = atlas.findRegion("walking - 3");
        runRight = new Animation(1 / 10f,
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
        sprintRight = new Animation(1 / 20f,
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
        dyingGreen = new Animation(1 / 2f,
                (atlas.findRegion("DyingGreen1")),
                (atlas.findRegion("DyingGreen-2")));

        atlas = new TextureAtlas("DEAD.pack");
        dead = atlas.findRegion("Dying2");
        dying = new Animation(1 / 2f,
                (atlas.findRegion("Dying1")),
                (atlas.findRegion("Dying2")));

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
        dyingRed = new Animation(1 / 2f,
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
        dyingBlue = new Animation(1 / 2f,
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
        dyingOrange = new Animation(1 / 2f,
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
        dyingPurple = new Animation(1 / 2f,
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
        dyingGrey = new Animation(1 / 2f,
                (atlas.findRegion("DyingGrey1")),
                (atlas.findRegion("DyingGrey2")));

        atlas = new TextureAtlas("COP.pack");
        standCop = atlas.findRegion("walkingCop - 3");
        runCop = new Animation(1 / 8f,
                (atlas.findRegion("walkingCop - 0.5")),
                (atlas.findRegion("walkingCop - 1")),
                (atlas.findRegion("walkingCop - 2")),
                (atlas.findRegion("walkingCop - 2.5")),
                (atlas.findRegion("walkingCop - 3")),
                (atlas.findRegion("walkingCop - 3.5")),
                (atlas.findRegion("walkingCop - 4")),
                (atlas.findRegion("walkingCop - 5")),
                (atlas.findRegion("walkingCop - 4")),
                (atlas.findRegion("walkingCop - 3.5")),
                (atlas.findRegion("walkingCop - 3")),
                (atlas.findRegion("walkingCop - 2.5")),
                (atlas.findRegion("walkingCop - 2")),
                (atlas.findRegion("walkingCop - 1")),
                (atlas.findRegion("walkingCop - 0.5")),
                (atlas.findRegion("walkingCop - 2.5")),
                (atlas.findRegion("walkingCop - 3")),
                (atlas.findRegion("walkingCop - 3.5")),
                (atlas.findRegion("walkingCop - 4")),
                (atlas.findRegion("walkingCop - 5")),
                (atlas.findRegion("walkingCop - 4")),
                (atlas.findRegion("walkingCop - 3.5")),
                (atlas.findRegion("walkingCop - 3")));

        atlas = new TextureAtlas("DEADCop.pack");
        deadCop = atlas.findRegion("DyingCop2");
        dyingCop = new Animation(1 / 2f,
                (atlas.findRegion("DyingCop1")),
                (atlas.findRegion("DyingCop2")));

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

        atlas = new TextureAtlas("M4Gun.pack");
        shootM4 = atlas.findRegion("M4Gun");
        flashM4 = atlas.findRegion("M4GunFlash");
        
      
        atlas = new TextureAtlas("healthbar.atlas");
        healthbar = atlas.findRegion("healthbar");
    }

}
