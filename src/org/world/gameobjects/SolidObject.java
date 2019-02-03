package org.world.gameobjects;


import org.GameContainer;
import org.graphics.Graphics;
import org.resources.Animation;
import org.resources.ImageResource;
import org.world.gameobjects.tiles.Tile;

public class SolidObject extends GameObject
{

	protected Hitbox hitbox;
	protected Animation animation = null;
	
	public SolidObject(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
		hitbox = new Hitbox(x, y, width, height);
	}
	
	public SolidObject(float x, float y, float width, float height, ImageResource img) 
	{
		super(x, y, width, height, img);
		hitbox = new Hitbox(x, y, width, height);
		
		if(img == Tile.bomb)
		{
			ImageResource[] bombsFrames = new ImageResource[4];
			for(int i = 0; i < bombsFrames.length; i++)
			{
				bombsFrames[i] = new ImageResource("entities/bomb/bomb"+i+".png");
			}
			
			animation = new Animation(bombsFrames, 5);
		}
	}
	
	public void render(Graphics g)
	{
		if(animation != null)
		{
			g.drawImage(animation.animate(), x, y, GameContainer.tileSize,  GameContainer.tileSize);
		}
		else
		{
			super.render(g);
		}
	}
	
	public Hitbox getHitbox()
	{
		return hitbox;
	}

	
	
}
