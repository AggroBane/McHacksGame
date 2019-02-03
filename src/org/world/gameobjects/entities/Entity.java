package org.world.gameobjects.entities;

import org.graphics.Color;
import org.resources.ImageResource;
import org.world.gameobjects.RigidBody;

public class Entity extends RigidBody
{

	public Entity(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
	}
	
	public Entity(float x, float y, float width, float height, Color color) 
	{
		super(x, y, width, height, color);
	}
	
	public Entity(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
	}
	
	public void move()
	{
		
	}

}
