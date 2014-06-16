/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuliy.example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author yilun
 */
public class Police extends AI {

    private TextureRegion frame = Assets.stand;
    private float time = 0;
    private int health;
    private int AIspeed = 120;
    private boolean isDead = false;

    public Police(float x, float y) {
        super(x, y);
        health = 200;
    }

    public void chase(Player p) {
        if (p.getX() > bounds.x) {
            velocity.x = AIspeed;
        } else if (p.getX() < bounds.x) {
            velocity.x = -AIspeed;
        }

        if (p.getY() > bounds.y) {
            velocity.y = AIspeed;
        } else if (p.getY() < bounds.y) {
            velocity.y = -AIspeed;
        }
    }

    public boolean isDead() {
        if (health <= 0) {
            isDead = true;
        }
        return isDead;
    }

    public void punched() {
        health -= 2;
    }

    public void shot() {
        health -= 25;
    }
}
