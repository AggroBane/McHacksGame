package org.world.gameobjects;

import org.graphics.Color;
import org.resources.ImageResource;

public class SolidObject extends GameObject
{


	public SolidObject(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
	}
	
	public SolidObject(float x, float y, float width, float height, Color color) 
	{
		super(x, y, width, height, color);
	}
	
	public SolidObject(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
	}
	
	
	

}
