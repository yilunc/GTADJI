/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuliy.example;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import static com.nuliy.example.Assets.atlas;

/**
 *
 * @author vonha4671
 */
public class DeadPed {

    private float x, y;
    private int type, lastRot;
    ;
    protected TextureRegion frame;
    protected Rectangle bounds;
    protected Vector2 velocity;
    protected float time = 0;

    public DeadPed(float x, float y, int lastRot, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.lastRot = lastRot - 270;
        this.frame = Assets.deadGreen;
        this.velocity = new Vector2(0, 0);
        this.bounds = new Rectangle(x, y, Assets.deadGreen.getRegionWidth(), Assets.deadGreen.getRegionHeight());
    }

    public void update(float deltaTime) {
        bounds.height = frame.getRegionHeight();
        bounds.width = frame.getRegionWidth();
        bounds.x += velocity.x * deltaTime;
        bounds.y += velocity.y * deltaTime;
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
    
    public Rectangle getBounds() {
        return bounds;
    }

    public void handleCollision(Rectangle c) {
        float x = Math.max(bounds.x, c.x);
        float y = Math.max(bounds.y, c.y);
        float width = Math.min(bounds.x + bounds.width, c.x + c.width) - x;
        float height = Math.min(bounds.y + bounds.height, c.y + c.height) - y;
        if (width < height) {
            if (bounds.x < c.x) {
                bounds.x = bounds.x - width;
            } else {
                bounds.x = bounds.x + width;
            }
        } else {
            if (bounds.y > c.y) {
                bounds.y = bounds.y + height;
            } else {
                bounds.y = bounds.y - height;
            }
        }
    }
}
