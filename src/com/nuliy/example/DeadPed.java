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
public class Deadpeople {

    private int x, y;
    protected TextureRegion frame;
    protected float time = 0;

    public Deadpeople(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawDead(SpriteBatch batch, int type, float deltaTime) {
        if (type == 1) {
            frame = Assets.DeadGreen;
            frame = Assets.DyingGreen
                    .getKeyFrame(time, false);
            batch.draw(frame, this.x, this.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
        }

        if (Assets.DyingGreen.getKeyFrame(time, false) == atlas.findRegion("DyingGreen-2")) {
            time = 0;
        } else {
            time += deltaTime;
        }
    }
}
