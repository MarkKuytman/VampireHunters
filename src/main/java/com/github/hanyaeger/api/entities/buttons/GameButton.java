package com.github.hanyaeger.api.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;


import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import launcher.VampireHunters;

public class GameButton extends Button {
	private int setScene;

    public GameButton(Coordinate2D initialLocation, String buttonText , VampireHunters vampireHunters, int activeScene) {
        super(initialLocation, buttonText , vampireHunters);
        setScene = activeScene;
    }

    @Override
    protected void handleButtonPressed() {
    	setActiveScene(setScene);
        
    }

    private void setActiveScene(int setScene) {
    	vampireHunters.setActiveScene(setScene);
	}

	@Override
    public void handleMouseEntered(){
        setFill(Color.RED);
        setCursor(Cursor.HAND);
    }

    @Override
    public void handleMouseExited(){
        setFill(Color.BEIGE);
        setCursor(Cursor.DEFAULT);
    }

	
}