package org.world.gameobjects.entities;

import java.awt.event.KeyEvent;

import org.GameContainer;
import org.graphics.Color;
import org.resources.Animation;
import org.resources.ImageResource;

public class Player extends Entity
{
	public Player(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
	}
	
	public Player(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
	}
	
	public void update(float delta)
	{
		super.update(delta);
		
		if(GameContainer.isKeyDown(KeyEvent.VK_A))
		{
			this.changeState(EntityState.LEFT);
		}
		else if(GameContainer.isKeyDown(KeyEvent.VK_D))
		{
			this.changeState(EntityState.RIGHT);
		}
		else
		{
			this.changeState(EntityState.IDLE);
		}
		
		if(GameContainer.isKeyDown(KeyEvent.VK_SPACE))
		{
			jump();
		}
		else
		{
			this.resetJump();
		}
	}
	
	public void render()
	{
		
	}

}
