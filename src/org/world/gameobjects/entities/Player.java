package org.world.gameobjects.entities;

import java.awt.event.KeyEvent;

import org.GameContainer;
import org.graphics.Color;
import org.resources.Animation;
import org.resources.ImageResource;
import org.world.gameobjects.Hitbox;

public class Player extends Entity
{
	
	private Animation playerWalk;

	private float spawnX, spawnY;
	
	public Player(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
		spawnX = 0;
		spawnY = 100;
	}
	
<<<<<<< HEAD
	public Player(float x, float y, float width, float height, Color color) 
	{
		super(x, y, width, height, color);
		spawnX = 0;
		spawnY = 100;
	}
	
=======
>>>>>>> 10006f44a57d52ed8437575e4f3894568093a23d
	public Player(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
		spawnX = 0;
		spawnY = 100;
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
		
		System.out.println(y);
		if(y < -80)
		{
			respawn();
		}
	}
	
	private void respawn()
	{
		x = spawnX;
		y = spawnY;
		hitbox = new Hitbox(x, y, width, height);
	}
	
	public void render()
	{
		
	}

}
