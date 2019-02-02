package org.world.gameobjects;

import org.graphics.Color;
import org.resources.ImageResource;

public class RigidBody extends SolidObject
{
	public RigidBody(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
	}
	
	public RigidBody(float x, float y, float width, float height, Color color) 
	{
		super(x, y, width, height, color);
	}
	
	public RigidBody(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
	}
	
	public void update()
	{
		//TODO: gravity
	}
}
