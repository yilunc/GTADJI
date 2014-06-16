/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuliy.example;

/**
 *
 * @author yilun
 */
public class Scoreboard {

    private int score;
    private int highScore;

    public Scoreboard() {
        score = 0;
        highScore = 0;
    }

    public void addScoreKilledPed() {
        score += 100;
    }

    public void addScoreKilledCop() {
        score += 300;
    }

    public void addScoreStoleCar() {
        score += 50;
    }
    
    public void saveHighscore() {
        highScore = score;
    }
}
