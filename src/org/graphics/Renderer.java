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
		
		window.setVisible(true);
		
		window.addGLEventListener(new EventListener());
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
