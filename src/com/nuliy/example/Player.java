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
 * 
 */
public class Player {

    private Rectangle bounds;
    private Vector2 velocity;
    float time = 0;
    private TextureRegion frame = Assets.stand;
    private int lastRot;

    public Player(float x, float y) {
        bounds = new Rectangle(x, y, Assets.stand.getRegionWidth(), Assets.stand.getRegionHeight());
        velocity = new Vector2(0, 0);
    }

    public void update(float deltaTime) {
        bounds.x += velocity.x * deltaTime;
        bounds.y += velocity.y * deltaTime;
        if (velocity.x != 0 || velocity.y != 0) {
            time += deltaTime;
        } else {
            time = 0;
        }
    }

    public void mouseAngle(double x, double y) {
        lastRot = (int) (Math.toDegrees(Math.atan2(Math.abs(bounds.y - y), Math.abs(bounds.x - x))));
        if (bounds.y > y && bounds.x > x){
            lastRot += 270;
        }else if (bounds.y > y && bounds.x < x){
            lastRot = 90 - lastRot;
        }else if (bounds.y < y && bounds.x < x){
            lastRot += 90;
        }else if (bounds.y < y && bounds.x > x){
            lastRot = 270 - lastRot;
        }
    }

    public void draw(SpriteBatch batch) {
        if (velocity.x > 0 && velocity.y == 0) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
            lastRot = 90;
        } else if (velocity.x < 0 && velocity.y == 0) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
            lastRot = 270;
        } else if (velocity.x == 0 && velocity.y > 0) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
            lastRot = 180;
        } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
            lastRot = 135;
        } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
            lastRot = 225;
        } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
            lastRot = 315;
        } else if (velocity.x == 0 && velocity.y < 0) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
            lastRot = 0;
        } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
            frame = Assets.runRight
                    .getKeyFrame(time, true);
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
            lastRot = 45;
        } else {
            frame = Assets.stand;
            batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, lastRot, true);
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getX() {
        return bounds.x;
    }

    public float getY() {
        return bounds.y;
    }

    public float getHeight() {
        return bounds.height;
    }

    public float getWidth() {
        return bounds.width;
    }

    public void setVelocity(float dx, float dy) {
        velocity.x = dx;
        velocity.y = dy;
    }

    public void setDX(float dx) {
        velocity.x = dx;
    }

    public void setDY(float dy) {
        velocity.y = dy;
    }

    public void setX(float x) {
        bounds.x = x;
    }

    public void setY(float y) {
        bounds.y = y;
    }

    //Ix = max (Ax,Bx)
    //Iy = max (Ay,By)
    //Iw = min (Ax+Aw, Bx+Bw) - x
    //Ih = min (Ay+Ah,Ay+Bh) - y
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
