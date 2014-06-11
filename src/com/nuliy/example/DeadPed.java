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

    public DeadPed(float x, float y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void drawDead(SpriteBatch batch, float deltaTime) {
        if (type == 1) {
            frame = Assets.deadGreen;
            frame = Assets.dyingGreen
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1.4f, 0.65f, 90, true);
        }

        if (Assets.dyingGreen.getKeyFrame(time, false) == atlas.findRegion("DyingGreen-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
    }
}
