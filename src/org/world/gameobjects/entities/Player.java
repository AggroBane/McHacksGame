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
	
	private int idleLeftAnimation = 0, idleRightAnimation = 1, walkLeftAnimation = 2, walkRightAnimation = 3;
	
	private Animation[] animations;
	private float spawnX, spawnY;
	private ImageResource jumpUpRight, jumpUpLeft, jumpDownRight, jumpDownLeft;
	float cameraDx = 0;
	
	public Player(float x, float y, float width, float height) 
	{
		super(x, y, width, height);

		spawnX = 0;
		spawnY = GameContainer.tileSize * 4;
		
		
		animations = new Animation[4];
		
		//idle
		ImageResource[] idleLeft = new ImageResource[2];
		for(int i = 0; i < idleLeft.length; i++)
		{
			idleLeft[i] = new ImageResource("entities/player/idle/player_idle"+i+"_left.png");
		}
		
		ImageResource[] idleRight = new ImageResource[2];
		for(int i = 0; i < idleRight.length; i++)
		{
			idleRight[i] = new ImageResource("entities/player/idle/player_idle"+i+"_right.png");
		}
		
		//walk
		ImageResource[] walkLeft = new ImageResource[6];
		for(int i = 0; i < walkLeft.length; i++)
		{
			walkLeft[i] = new ImageResource("entities/player/walk/player_walk"+i+"_left.png");
		}
		
		ImageResource[] walkRight = new ImageResource[6];
		for(int i = 0; i < walkRight.length; i++)
		{
			walkRight[i] = new ImageResource("entities/player/walk/player_walk"+i+"_right.png");
		}
		
		//jumpUp
		jumpUpLeft = new ImageResource("entities/player/jump/player_jumpUp_left.png");
		jumpUpRight = new ImageResource("entities/player/jump/player_jumpUp_right.png");
		jumpDownLeft = new ImageResource("entities/player/jump/player_jumpDown_left.png");
		jumpDownRight = new ImageResource("entities/player/jump/player_jumpDown_right.png");
		
		animations[idleLeftAnimation] = new Animation(idleLeft, 2);
		animations[idleRightAnimation] = new Animation(idleRight, 2);
		animations[walkLeftAnimation] = new Animation(walkLeft, 25);
		animations[walkRightAnimation] = new Animation(walkRight, 25);
	}
	
	
	public void update(float delta)
	{
		super.update(delta);
		
		if(GameContainer.isKeyDown(KeyEvent.VK_A))
		{
			this.changeState(EntityState.LEFT);
			this.changeSight(FacingState.LEFT);
		}
		else if(GameContainer.isKeyDown(KeyEvent.VK_D))
		{
			this.changeState(EntityState.RIGHT);
			this.changeSight(FacingState.RIGHT);
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
		if(facing == FacingState.RIGHT) 
		{
			if(isJumping)
			{
				g.drawImage(jumpUpRight, x, y, width, height);
			}
			else if(state == EntityState.RIGHT)
			{
				g.drawImage(animations[walkRightAnimation].animate(), x, y, width, height);
			}
			else //Idle
			{
				g.drawImage(animations[idleRightAnimation].animate(), x, y, width, height);
			}	
		}else
			if(isJumping)
			{
				g.drawImage(jumpUpLeft, x, y, width, height);
			}
			else if(state == EntityState.LEFT)
			{
				g.drawImage(animations[walkLeftAnimation].animate(), x, y, width, height);
			}
			else //Idle
			{
				g.drawImage(animations[idleLeftAnimation].animate(), x, y, width, height);
			}
		
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
