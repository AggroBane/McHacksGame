package org.state;

import java.util.ArrayList;

import org.graphics.Color;
import org.graphics.Graphics;
import org.resources.ImageResource;
import org.world.gameobjects.GameObject;

public class MenuState 
{
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public MenuState()
	{
		objects.add(new GameObject(0, 50, 50, 50, new ImageResource("smile.png")));
	}
	
	public void load()
	{
		
	}
	
	public void update(float delta)
	{
		for(GameObject go : objects)
		{
			go.update(delta);
		}
	}
	
	public void render(Graphics g)
	{
		for(GameObject go : objects)
		{
			go.render(g);
		}
	}
}
