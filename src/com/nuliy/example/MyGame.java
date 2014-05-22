package com.nuliy.example;

import com.badlogic.gdx.Game;
public class MyGame extends Game{
	
    private GameScreen gameScreen;
    
	@Override
	public void create () {
            //sets games screen
             //can call game screen anytime now
             setScreen(new MainMenu(this));
             this.resize(800, 600);
	}
}