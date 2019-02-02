package org.engine;

import java.awt.event.KeyEvent;

import org.GameContainer;
import org.graphics.Renderer;

public class GameLoop 
{
	private final static byte FPS = 60;
	private final static long TARGET_TIME = 1_000_000_000 / FPS;
	private final static byte MAX_UPDATES = 5; 
	
	
	public static void start()
	{
		Thread thread = new Thread()
		{
			public void run()
			{
				boolean running = true;
				long lastTime = System.nanoTime();
				long currentTime;
				byte updates;
				
				boolean fpsCounter = false;
				byte fps = 0;
				long lastFpsCheck = System.nanoTime();
				
				while(running)
				{
					currentTime = System.nanoTime();
					updates = 0;
					
					while(currentTime - lastTime >= TARGET_TIME && updates < MAX_UPDATES)
					{
						//updates poll
						lastTime += TARGET_TIME;
						updates++;
					}
					
					if(fpsCounter && System.nanoTime() > lastFpsCheck + 1_000_000_000)
					{
						System.out.println(fps);
						lastFpsCheck = System.nanoTime();
						fps = 0;
					}
					
					if(GameContainer.isKeyDown(KeyEvent.VK_W)) System.out.println("W");
					
					//render poll
					Renderer.render();
					fps++;
					
					long timeTaken = System.nanoTime() - currentTime;
					//sleep thread
					if(timeTaken <= TARGET_TIME)
					{
						try 
						{
							Thread.sleep((TARGET_TIME - timeTaken) / 1_000_000);
						} catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
					}
				}
			}
		};
		
		thread.setName("GameLoop");
		thread.start();
	}
}
