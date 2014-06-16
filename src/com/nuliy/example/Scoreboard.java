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

    public void addScoreKilledPed(Player p) {
        score += 100 * (Math.ceil(p.getWantedLvl()/100) + 1);
    }

    public void addScoreKilledCop(Player p) {
        score += 300 * (Math.ceil(p.getWantedLvl()/100) + 1);
    }

    public void addScoreStoleCar(Player p) {
        score += 50 * (Math.ceil(p.getWantedLvl()/100) + 1);
    }

    public void saveHighscore() {
        highScore = score;
    }

    public void scoreReset() {
        score = 0;
    }
    
    public int returnScore(){
        return score;
    }
    
    public int returnHighscore(){
        return highScore;
    }
}
