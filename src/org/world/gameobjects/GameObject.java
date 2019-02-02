package org.world.gameobjects;

import org.graphics.Color;
import org.graphics.Graphics;
import org.resources.ImageResource;

public class GameObject 
{
	private float x, y, width, height;
	private Color color;
	private ImageResource img;
	
	public GameObject(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameObject(float x, float y, float width, float height, Color color)
	{
		this(x, y, width, height);
		this.color = color;
	}
	
	public GameObject(float x, float y, float width, float height, ImageResource img)
	{
		this(x, y, width, height);
		this.img = img;
	}
	
	public void update(float delta)
	{
		//No updates
	}
	
	public void render(Graphics g)
	{
		if(img != null) 
		{
			g.drawImage(img, x, y, width, height);
		}
		else if(color != null)
		{
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
	}
}
