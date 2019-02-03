package org.world.gameobjects;


import org.resources.ImageResource;

public class SolidObject extends GameObject
{

	protected Hitbox hitbox;
	
	public SolidObject(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
		hitbox = new Hitbox(x, y, width, height);
	}
	
	public SolidObject(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
		hitbox = new Hitbox(x, y, width, height);
	}
	
	public Hitbox getHitbox()
	{
		return hitbox;
	}

	
	
}
