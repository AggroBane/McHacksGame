package org.state;


import java.io.IOException;
import java.util.ArrayList;

import org.GameContainer;
import org.graphics.Graphics;
import org.levels.Levels;
import org.resources.ImageResource;
import org.world.gameobjects.GameObject;
import org.world.gameobjects.SolidObject;
import org.world.gameobjects.entities.Player;


public class GameState 
{
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private static ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	private Player player;
	private ImageResource background;
	private static float backgroundX = 0;
	
	public GameState()
	{
		player = new Player(0, 4 * GameContainer.tileSize, GameContainer.tileSize, GameContainer.tileSize);
		
		background = new ImageResource("world/background/blue_sky.png");
		
		try 
		{
			objects = Levels.createObjectFromFile("level1");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		for(GameObject obj : objects)
		{
			if(obj instanceof SolidObject) solidObjects.add((SolidObject) obj);
		}
		solidObjects.add(player);
		objects.add(player);
	}
	
	public void update(float delta)
	{
		for(GameObject ob : objects)
		{
			ob.update(delta);
		}
	}
	
	public void render(Graphics g)
	{	
		
		
		if(player.getX() > GameContainer.WIDTH / 2 - player.getWidth() / 2)
		{
			backgroundX += player.getXMove();
		}
		
		g.drawImage(background, backgroundX-GameContainer.tileSize, GameContainer.HEIGHT, GameContainer.WIDTH+GameContainer.tileSize * 2, GameContainer.HEIGHT);
		
		for(GameObject ob : objects)
		{
			ob.render(g);
		}
	}
	
	public static ArrayList<SolidObject> getSolidObjects()
	{
		return solidObjects;
	}
	
	public static void respawnPlayer()
	{
		backgroundX = 0;
	}
}
