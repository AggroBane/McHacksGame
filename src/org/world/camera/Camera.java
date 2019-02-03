package org.world.camera;

import org.GameContainer;
import org.graphics.Graphics;

public class Camera 
{
	private float x, y, dx, dy;
	
	public Camera()
	{
		this.x = 0;
		this.y = GameContainer.HEIGHT;
	}
	
	
	public void setPosition(float x, float y)
	{
		if(this.x == -x)
		{
			dx = (x - this.x) / -1;
		}
		


	}
	
	public void render(Graphics g)
	{
		if(dx != 0 || dy != 0)
		{
			g.translate(-dx, 0);
			x += dx;
			y += dy;
			dx = 0;
			dy = 0;
		}
	}

}
