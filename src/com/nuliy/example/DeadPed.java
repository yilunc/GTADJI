/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuliy.example;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import static com.nuliy.example.Assets.atlas;

/**
 *
 * @author vonha4671
 */
public class DeadPed {

    private int x, y;
    protected TextureRegion frame;
    protected float time = 0;

    public DeadPed(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawDead(SpriteBatch batch, int type, float deltaTime) {
       if(type == 1)
       {
        if (true) {
            frame = Assets.deadBlue;
            frame = Assets.DyingBlue
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingBlue.getKeyFrame(time, false) == atlas.findRegion("DyingBlue-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
       }
        
         if(type == 2)
       {
        if (true) {
            frame = Assets.deadRed;
            frame = Assets.DyingRed
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingRed.getKeyFrame(time, false) == atlas.findRegion("DyingRed-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
       }
           
             if(type == 3)
       {
        if (true) {
            frame = Assets.deadBlue;
            frame = Assets.DyingBlue
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingBlue.getKeyFrame(time, false) == atlas.findRegion("DyingBlue-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
       }
             
               if(type == 4)
       {
        if (true) {
            frame = Assets.deadOrange;
            frame = Assets.DyingOrange
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingOrange.getKeyFrame(time, false) == atlas.findRegion("DyingOrange-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
       }
               
                 if(type == 5)
       {
        if (true) {
            frame = Assets.deadPurple;
            frame = Assets.DyingPurple
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingPurple.getKeyFrame(time, false) == atlas.findRegion("DyingPurple-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
       }
                 
                 if(type == 6)
       {
        if (true) {
            frame = Assets.deadGrey;
            frame = Assets.DyingGrey
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingGrey.getKeyFrame(time, false) == atlas.findRegion("DyingGrey-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
       }             
    }
}
