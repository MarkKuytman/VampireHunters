package com.github.hanyaeger.api.entities;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


public class PlayerCharacter extends DynamicSpriteEntity{
	
	public PlayerCharacter(Coordinate2D location) {
	super("sprites/adventurer-step.png", location);
		
		setMotion(2, 270d);

	
	
		// TODO Auto-generated constructor stub
	}
	
	
}
