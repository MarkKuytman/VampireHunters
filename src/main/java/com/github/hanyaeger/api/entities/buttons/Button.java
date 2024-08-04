package com.github.hanyaeger.api.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import launcher.VampireHunters;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener{

    protected VampireHunters vampireHunters;

    public Button(Coordinate2D initialLocation, String text, VampireHunters vampireHunters) {
        super(initialLocation, text);
        setFill(Color.BLACK);
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Ticketing.ttf"), 50);
        setFont(customFont);
        setFill(Color.WHITE);
        setViewOrder(0.0);
        this.vampireHunters = vampireHunters;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        handleButtonPressed();
    }
    
    @Override
	public void onMouseEntered() {
    	handleMouseEntered();
	}

	@Override
	public void onMouseExited() {
		handleMouseExited();
	}
	
	protected abstract void handleMouseEntered();
	
	protected abstract void handleMouseExited();
	
    protected abstract void handleButtonPressed();
}