package org.world.gameobjects.menu;

import org.graphics.Color;
import org.resources.ImageResource;
import org.world.gameobjects.GameObject;

public class Button extends GameObject
{

	public Button(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
	}
	
	public Button(float x, float y, float width, float height, Color color) 
	{
		super(x, y, width, height, color);
	}
	
	public Button(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
	}
	
	public void update(float delta)
	{
		//Checking if it is pressed
	}

}
