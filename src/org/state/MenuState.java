package org.state;

import java.util.ArrayList;

import org.graphics.Graphics;
import org.resources.ImageResource;
import org.world.gameobjects.GameObject;
import org.world.gameobjects.SolidObject;
import org.world.gameobjects.entities.Player;

public class MenuState 
{
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	static ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	
	public MenuState()
	{
		Player kindOfPlayer = new Player(500, 400, 50, 50, new ImageResource("smile.png"));
		SolidObject obstacle = new SolidObject(500, 50, 50, 50, new ImageResource("jhv"));
		SolidObject obstacle1 = new SolidObject(550, 50, 50, 50, new ImageResource("jhv"));
		SolidObject obstacle2 = new SolidObject(600, 50, 50, 50, new ImageResource("jhv"));
		SolidObject obstacle3 = new SolidObject(600, 300, 50, 50, new ImageResource("jhv"));

		
		solidObjects.add(kindOfPlayer);
		solidObjects.add(obstacle);
		solidObjects.add(obstacle1);
		solidObjects.add(obstacle2);
		solidObjects.add(obstacle3);

		objects.add(kindOfPlayer);
		objects.add(obstacle);
		objects.add(obstacle1);
		objects.add(obstacle2);
		objects.add(obstacle3);


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
		for(GameObject ob : objects)
		{
			ob.render(g);
		}
	}
	
	
	
	//TODO: get only close to player solidObject
	public static ArrayList<SolidObject> getSolidObjects()
	{
		return solidObjects;
	}
}
