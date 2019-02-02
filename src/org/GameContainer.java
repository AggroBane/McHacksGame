package org;

import org.engine.GameLoop;
import org.graphics.Renderer;

public class GameContainer 
{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String NAME = "Game";
	
	//GameIcon
	
	
	
	public static void main(String[] args)
	{
		Renderer.init();
		GameLoop.start();
	}
}
