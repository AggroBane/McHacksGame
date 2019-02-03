package org;

import org.engine.GameLoop;
import org.graphics.Renderer;
import org.inputs.KeyInput;
import org.inputs.MouseInput;
import org.state.StateManager;

public class GameContainer 
{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final int tileSize = 32;
	public static final String NAME = "Game";
	
	private static StateManager stateManager;
	
	private static KeyInput keyListener;
	private static MouseInput mouseListener;
	
	//GameIcon
	
	public GameContainer()
	{
		stateManager = new StateManager();
		stateManager.init();
		
		
		keyListener = new KeyInput();
		mouseListener = new MouseInput();
	}
	
	public static KeyInput getKeyListener() 
	{
		return keyListener;
	}

	public static boolean isKeyDown(int keyCode)
	{
		return keyListener.isKeyDown(keyCode);
	}
	
	public static float getMouseX()
	{
		return mouseListener.getMouseX();
	}
	
	public static float getMouseY()
	{
		return mouseListener.getMouseY();
	}
	

	public static MouseInput getMouseListener() 
	{
		return mouseListener;
	}
	
	public static StateManager getStateManager() 
	{
		return stateManager;
	}

	public static void main(String[] args)
	{
		new GameContainer(); //Init
		
		Renderer.init();
		
		GameLoop.start();
	}
}
