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
 * @author yilun
 */
public class AI {

    protected Rectangle bounds;
    protected Vector2 velocity;
    protected TextureRegion frame = Assets.stand;
    protected float time = 0;
    protected int AImovedecider, AImovetimer, health, lastRot, distance;

    public AI(float x, float y) {
        bounds = new Rectangle(x, y, Assets.stand.getRegionWidth(), Assets.stand.getRegionHeight());
        velocity = new Vector2(0, 0);
    }

    public void update(float deltaTime) {
        bounds.height = frame.getRegionHeight();
        bounds.width = frame.getRegionWidth();
        bounds.x += velocity.x * deltaTime;
        bounds.y += velocity.y * deltaTime;
        if (velocity.x != 0 || velocity.y != 0) {
            time += deltaTime;
        } else {
            time = 0;
        }
    }

    public void draw(SpriteBatch batch, int type) {
        if (type == 1) {
            frame = Assets.standGreen;
            if (velocity.x > 0 && velocity.y == 0) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
                lastRot = 90;
            } else if (velocity.x < 0 && velocity.y == 0) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
                lastRot = 270;
            } else if (velocity.x == 0 && velocity.y > 0) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
                lastRot = 180;
            } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
                lastRot = 225;
            } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
                lastRot = 315;
            } else if (velocity.x == 0 && velocity.y < 0) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
                lastRot = 0;
            } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
                frame = Assets.runGreen
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
                lastRot = 45;
            } else {
                frame = Assets.standGreen;
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            }
        }

        if (type == 2) {
            frame = Assets.standRed;
            if (velocity.x > 0 && velocity.y == 0) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
                lastRot = 90;
            } else if (velocity.x < 0 && velocity.y == 0) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
                lastRot = 270;
            } else if (velocity.x == 0 && velocity.y > 0) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
                lastRot = 180;
            } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
                lastRot = 225;
            } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
                lastRot = 315;
            } else if (velocity.x == 0 && velocity.y < 0) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
                lastRot = 0;
            } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
                frame = Assets.runRed
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
                lastRot = 45;
            } else {
                frame = Assets.standRed;
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            }
        }

        if (type == 3) {
            frame = Assets.standBlue;
            if (velocity.x > 0 && velocity.y == 0) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
                lastRot = 90;
            } else if (velocity.x < 0 && velocity.y == 0) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
                lastRot = 270;
            } else if (velocity.x == 0 && velocity.y > 0) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
                lastRot = 180;
            } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
                lastRot = 225;
            } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
                lastRot = 315;
            } else if (velocity.x == 0 && velocity.y < 0) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
                lastRot = 0;
            } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
                frame = Assets.runBlue
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
                lastRot = 45;
            } else {
                frame = Assets.standBlue;
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            }
        }

        if (type == 4) {
            frame = Assets.standOrange;
            if (velocity.x > 0 && velocity.y == 0) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
                lastRot = 90;
            } else if (velocity.x < 0 && velocity.y == 0) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
                lastRot = 270;
            } else if (velocity.x == 0 && velocity.y > 0) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
                lastRot = 180;
            } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
                lastRot = 225;
            } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
                lastRot = 315;
            } else if (velocity.x == 0 && velocity.y < 0) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
                lastRot = 0;
            } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
                frame = Assets.runOrange
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
                lastRot = 45;
            } else {
                frame = Assets.standOrange;
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            }
        }

        if (type == 5) {
            frame = Assets.standPurple;
            if (velocity.x > 0 && velocity.y == 0) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
                lastRot = 90;
            } else if (velocity.x < 0 && velocity.y == 0) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
                lastRot = 270;
            } else if (velocity.x == 0 && velocity.y > 0) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
                lastRot = 180;
            } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
                lastRot = 225;
            } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
                lastRot = 315;
            } else if (velocity.x == 0 && velocity.y < 0) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
                lastRot = 0;
            } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
                frame = Assets.runPurple
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
                lastRot = 45;
            } else {
                frame = Assets.standPurple;
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            }
        }

        if (type == 6) {
            frame = Assets.standGrey;
            if (velocity.x > 0 && velocity.y == 0) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 90, true);
                lastRot = 90;
            } else if (velocity.x < 0 && velocity.y == 0) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 270, true);
                lastRot = 270;
            } else if (velocity.x == 0 && velocity.y > 0) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 180, true);
                lastRot = 180;
            } else if (velocity.x > 0 && velocity.y > 0 && velocity.x == velocity.y) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            } else if (velocity.x < 0 && velocity.y > 0 && -velocity.x == velocity.y) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 225, true);
                lastRot = 225;
            } else if (velocity.x < 0 && velocity.y < 0 && velocity.x == velocity.y) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 315, true);
                lastRot = 315;
            } else if (velocity.x == 0 && velocity.y < 0) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);

                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0, true);
                lastRot = 0;
            } else if (velocity.x > 0 && velocity.y < 0 && velocity.x == -velocity.y) {
                frame = Assets.runGrey
                        .getKeyFrame(time, true);
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 45, true);
                lastRot = 45;
            } else {
                frame = Assets.standGrey;
                batch.draw(frame, bounds.x, bounds.y, frame.getRegionWidth() / 2, frame.getRegionHeight() / 2, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 135, true);
                lastRot = 135;
            }
        }
    }

    public void move(int AIspeed) {
        if (AImovetimer <= 0) {
            AImovetimer = (int) (Math.random() * 100);
            AImovedecider = (int) (Math.random() * 5);
        }

        if (AImovetimer >= 0) {
            if (AImovedecider == 0) {
                velocity.x = AIspeed;
            } else if (AImovedecider == 1) {
                velocity.x = -AIspeed;
            } else if (AImovedecider == 2) {
                velocity.y = AIspeed;
            } else if (AImovedecider == 3) {
                velocity.y = -AIspeed;
            } else if (AImovedecider == 4) {
                velocity.x = 0;
                velocity.y = 0;
            }
            AImovetimer--;
        }
    }

    public void scared(Player p, int AIspeed) {
        if (p.getX() > bounds.x) {
            velocity.x = -AIspeed;
        } else if (p.getX() < bounds.x) {
            velocity.x = AIspeed;
        }

        if (p.getY() > bounds.y) {
            velocity.y = -AIspeed;
        } else if (p.getY() < bounds.y) {
            velocity.y = AIspeed;
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getX() {
        return bounds.x;
    }

    public int getLastRot() {
        return lastRot;
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

    public void setX(float x) {
        bounds.x = x;
    }

    public void setY(float y) {
        bounds.y = y;
    }

    public int distanceFrom(Player p) {
        distance = (int) Math.sqrt((Math.pow(bounds.x - p.getX(), 2) + Math.pow(bounds.y - p.getY(), 2)));
        return distance;
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
