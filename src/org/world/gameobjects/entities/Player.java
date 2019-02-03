package org.world.gameobjects.entities;

import java.awt.event.KeyEvent;

import org.GameContainer;
import org.graphics.Color;
import org.graphics.Graphics;
import org.resources.Animation;
import org.resources.ImageResource;
import org.world.gameobjects.Hitbox;

public class Player extends Entity
{

	private int idleAnimation = 0, walkAnimation = 1;
	
	private Animation[] animations;
	private float spawnX, spawnY;
	private ImageResource jumpImg;
	float cameraDx = 0;
	

	public Player(float x, float y, float width, float height) 
	{
		super(x, y, width, height);

		spawnX = 0;
		spawnY = GameContainer.tileSize * 2;
		
		animations = new Animation[3];
		
		//idle
		ImageResource[] idleFrames = new ImageResource[2];
		for(int i = 0; i < idleFrames.length; i++)
		{
			idleFrames[i] = new ImageResource("entities/player/idle/player_idle"+i+".png");
		}
		
		//walk
		ImageResource[] walkFrames = new ImageResource[6];
		for(int i = 0; i < walkFrames.length; i++)
		{
			walkFrames[i] = new ImageResource("entities/player/walk/player_walk"+i+".png");
		}
		
		//jump
		jumpImg = new ImageResource("entities/player/jump/Player_JumpUp.png");
		
		animations[idleAnimation] = new Animation(idleFrames, 2);
		animations[walkAnimation] = new Animation(walkFrames, 4);
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
		
		if(y < -80)
		{
			respawn();
		}
	}
	
	private void respawn()
	{
		if(0 < GameContainer.WIDTH / 2 - width / 2)
		{
			float halfScreen = -(GameContainer.WIDTH / 2 - width / 2);
			cameraDx = halfScreen - x - halfScreen - halfScreen;
		}
		
		x = spawnX;
		y = spawnY;
		hitbox = new Hitbox(x, y, width, height);
	}
	
	public void render(Graphics g)
	{
		if(isJumping)
		{
			g.drawImage(jumpImg, x, y, width, height);
		}
		else if(state == EntityState.IDLE)
		{
			g.drawImage(animations[idleAnimation].animate(), x, y, width, height);
		}

		else if(state == EntityState.LEFT || state == EntityState.RIGHT)
		{
			g.drawImage(animations[walkAnimation].animate(), x, y, width, height);
		}
		
		//If the player respawns
		if(cameraDx != 0)
		{
			g.translate(-cameraDx, 0);
			cameraDx = 0;
		}
		else if(x > GameContainer.WIDTH / 2 - width / 2)
		{
			g.translate(-xMove, 0);
		}

	

	}

}
