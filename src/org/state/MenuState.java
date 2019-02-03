package org.state;

import java.util.ArrayList;

import org.graphics.Graphics;
import org.world.gameobjects.GameObject;
import org.world.gameobjects.menu.Button;

public class MenuState 
{
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public MenuState()
	{
		objects.add(new Button(50, 50, 50, 50));

	}
	
	public void update(float delta)
	{
		for(GameObject obj : objects)
		{
			obj.update(delta);
		}
	}
	
	public void render(Graphics g)
	{

	}
	
	
	

}
