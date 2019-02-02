package org.graphics;

import org.GameContainer;


import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

public class Renderer 
{
	private static GLProfile profile;
	private static GLCapabilities caps;
	private static GLWindow window;
	

	public static void init()
	{
		GLProfile.initSingleton();
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		window = GLWindow.create(caps);
		
		window.setResizable(false);
		window.setTitle(GameContainer.NAME);
		window.setSize(GameContainer.WIDTH, GameContainer.HEIGHT);
		
		//Listeners
		window.addGLEventListener(new EventListener());
		window.addKeyListener(GameContainer.getKeyListener());
		window.addMouseListener(GameContainer.getMouseListener());
		
		window.setVisible(true);
	}
	
	public static void render()
	{
		if(window != null)
		{
			window.display();
		}
	}
	
	public static GLProfile getProfile()
	{
		return profile;
	}
}
