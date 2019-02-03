package org.resources;

public class Animation 
{
	private ImageResource[] frames;
	private int fps;
	private int actualFrame = -1;
	private long targetTime = 1_000_000_000 / fps;
	private long lastTime;
	
	public Animation(ImageResource[] frames, int fps)
	{
		this.frames = frames;
		this.fps = fps;
	}
	
	
	public void animate()
	{
		if(actualFrame == -1)
		{
			lastTime = System.nanoTime();
			actualFrame++;
		}
		else
		{
			if(System.nanoTime() - lastTime >= targetTime)
			{
				actualFrame++;
			}
		}
	}
	
	public int getActualFrame()
	{
		return actualFrame;
	}

}
