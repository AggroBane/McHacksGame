package org.world.gameobjects;

import org.GameContainer;
import org.graphics.Color;
import org.resources.ImageResource;
import org.state.GameState;
import org.world.gameobjects.entities.EntityState;
import org.world.gameobjects.entities.FacingState;
import org.world.gameobjects.entities.Player;

public class RigidBody extends SolidObject
{
	public static final float GRAVITY = -0.02f;
	public static final float SPEED = 0.2f;
	public static final float MAX_GRAVITY_STACK = -1f;

	public static final float JUMP_SPEED = 0.5f;
	public static final float MAX_JUMP = 1f;
	public static final int MAX_JUMP_FRAME = 25;
	
	protected int jumpFrame = 0;
	protected boolean canJump = true;
	protected boolean isJumping = false;
	
	protected float gravityStack = 0;
	
	protected EntityState state = EntityState.IDLE;
	protected FacingState facing = FacingState.RIGHT;
	
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
	

	public void update(float delta)
	{
		float dX = 0, dY = 0;
	
		
		//Checking if the move is possible
		if(state == EntityState.RIGHT)
		{
			dX = SPEED;
		}
		if(state == EntityState.LEFT)
		{
			dX = -SPEED;
		}

		
		hitbox.move(dX, 0);
		
		//X MOVEMENT
		for(SolidObject so : GameState.getSolidObjects())
		{
			if(!(so instanceof Player))
			{
				//If the hitbox intersects with another solidObject
				if(hitbox.intersect(so.getHitbox()) && x + dX > 0)
				{
					//Cancel the move
					state = EntityState.IDLE;
					//Replace the hitbox at its initial place
					hitbox.move(-dX, 0);
					dX = 0;
					if(isJumping) resetJump();
				}
			}
		}
		
		move(dX, 0);

		
		if(isJumping)
		{
			dY = JUMP_SPEED;
			hitbox.move(0, dY);
			for(SolidObject so : GameState.getSolidObjects())
			{
				if(!(so instanceof Player))
				{
					if(hitbox.intersect(so.hitbox))
					{
						hitbox.move(0, -dY);
						dY = 0;
					}
				}
			}
			
			move(0, dY);
		}
		else
		{
			if(gravityStack + GRAVITY >= MAX_GRAVITY_STACK)
			{
				dY = gravityStack += GRAVITY;
			}
			else
			{
				dY = MAX_GRAVITY_STACK;
			}
			
			hitbox.move(0, dY);
			
			//Y MOVEMENT
			for(SolidObject so : GameState.getSolidObjects())
			{
				if(!(so instanceof Player))
				{
					if(hitbox.intersect(so.getHitbox()))
					{
						state = EntityState.IDLE;
						hitbox.move(0, -dY);
						dY = 0;
						canJump = true;
						gravityStack = 0;
						break;
					}
				}
			}	
			
			move(0, dY);
		}
	}
	
	
	public void jump()
	{
		if(jumpFrame < MAX_JUMP_FRAME && canJump)
		{
			isJumping = true;
			
			jumpFrame++;
		}
		else
		{
			resetJump();
		}

	}
	
	public void resetJump()
	{
		canJump = false;
		isJumping = false;
		jumpFrame = 0;
	}
	
	public void changeSight(FacingState facing) {
		this.facing = facing;
	}

	public void changeState(EntityState state)
	{
		this.state = state; 
	}
	
	private void move(float dX, float dY)
	{
		x += GameContainer.tileSize / 2 * dX;
		y += GameContainer.tileSize / 2 * dY;
	}
	
	
	public void setIsJumping(boolean isJumping)
	{
		this.isJumping = isJumping;
	}
}
