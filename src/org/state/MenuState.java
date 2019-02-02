package org.state;

import java.util.ArrayList;

import org.graphics.Graphics;
import org.resources.ImageResource;
import org.world.gameobjects.GameObject;
import org.world.gameobjects.menu.Button;

public class MenuState 
{
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public MenuState()
	{
		objects.add(new Button(0, 50, 50, 50, new ImageResource("smile.png")));
	}
	
	public void update(float delta)
	{
		//no updates?
	}
	
	public void render(Graphics g)
	{
		for(GameObject go : objects)
		{
			go.render(g);
		}
	}
}
