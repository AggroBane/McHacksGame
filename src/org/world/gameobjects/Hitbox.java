package org.world.gameobjects;

import org.GameContainer;

public class Hitbox 
{
	float x, y, width, height;
	
	public Hitbox(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	public void move(float deltaX, float deltaY)
	{
		x += GameContainer.tileSize / 2 * deltaX;
		y += GameContainer.tileSize / 2 * deltaY;
	}
	
	
	public boolean intersect(Hitbox other)
	{
		return x < other.x + other.width && 
			    x + width > other.x &&
			    y < other.y + other.height && 
			   y + height > other.y;
	}
}
