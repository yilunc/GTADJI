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

    private float x, y;
    private int type;
    protected TextureRegion frame;
    protected float time = 0;
    private int lastRot;
    
    public DeadPed(float x, float y, int lastRot, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.lastRot = lastRot;
    }

    public void drawDead(SpriteBatch batch, float deltaTime) {
        if (type == 1) {
            if (true) {
                frame = Assets.dyingGreen
                        .getKeyFrame(time, false);
                batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, lastRot, true);
            }

            if (Assets.dyingGreen.getKeyFrame(time, false) == atlas.findRegion("dyingGreen-2")) {
                time = 0;
            } else {
                time += deltaTime;
            }
        }

        if (type == 2) {
            if (true) {
                frame = Assets.dyingRed
                        .getKeyFrame(time, false);
                batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, lastRot, true);
            }

            if (Assets.dyingRed.getKeyFrame(time, false) == atlas.findRegion("dyingRed-2")) {
                time = 0;
            } else {
                time += deltaTime;
            }
        }

        if (type == 3) {
            if (true) {
                frame = Assets.deadBlue;
                frame = Assets.dyingBlue
                        .getKeyFrame(time, false);
                batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, lastRot, true);
            }

            if (Assets.dyingBlue.getKeyFrame(time, false) == atlas.findRegion("dyingBlue-2")) {
                time = 0;
            } else {
                time += deltaTime;
            }
        }

        if (type == 4) {
            if (true) {
                frame = Assets.deadOrange;
                frame = Assets.dyingOrange
                        .getKeyFrame(time, false);
                batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, lastRot, true);
            }

            if (Assets.dyingOrange.getKeyFrame(time, false) == atlas.findRegion("dyingOrange-2")) {
                time = 0;
            } else {
                time += deltaTime;
            }
        }

        if (type == 5) {
            if (true) {
                frame = Assets.deadPurple;
                frame = Assets.dyingPurple
                        .getKeyFrame(time, false);
                batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, lastRot, true);
            }

            if (Assets.dyingPurple.getKeyFrame(time, false) == atlas.findRegion("dyingPurple-2")) {
                time = 0;
            } else {
                time += deltaTime;
            }
        }

        if (type == 6) {
            if (true) {
                frame = Assets.deadGrey;
                frame = Assets.dyingGrey
                        .getKeyFrame(time, false);
                batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, lastRot, true);
            }

            if (Assets.dyingGrey.getKeyFrame(time, false) == atlas.findRegion("dyingGrey-2")) {
                time = 0;
            } else {
                time += deltaTime;
            }
        }
    }
}
