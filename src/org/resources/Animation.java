package org.resources;

public class Animation 
{
	private ImageResource[] frames;
	private int fps;
	private int actualFrame = -1;
	private int maxFrame;
	private long targetTime;
	private long lastTime;
	
	public Animation(ImageResource[] frames, int fps)
	{
		this.frames = frames;
		this.fps = fps;
		targetTime = 1_000_000_000 / fps;
		maxFrame = frames.length;
	}
	
	
	public ImageResource animate()
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
				lastTime = System.nanoTime();
				if(maxFrame <= actualFrame) actualFrame = 0;
			}
		}
		
		return frames[actualFrame];
	}
	
	public int getActualFrame()
	{
		return actualFrame;
	}

}
