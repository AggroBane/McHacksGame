package org.resources;

import java.awt.image.BufferedImage;

import org.graphics.Graphics;

public class Animation {
	//Speed and # of frames in animation
	private int speed, frames;
	
	//What we are currently at and what we need to be at
	private int index = 0;
	private int count = 0;
	
	private ImageResource[] images; //How many images we have
	private ImageResource currentImg; //What image we are to display
	
	public Animation(int speed, ImageResource...args) {
		this.speed = speed;
		//Setting the right image
		images = new ImageResource[args.length];
		for(int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
	}
	
	public void runAnimation() {
		index++;
		if(index >speed) {
			index = 0;
			nextFrame();
		}
	}
	
	
	
	private void nextFrame() {
		for(int i = 0; i<frames; i++) {
			if(count == i)
				currentImg = images[i];
		
		}
		count++;
		//Resets the animation once it has passed
		if (count > frames) count = 0;
	}
	
	private void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, currentImg.getTexture().getWidth(), currentImg.getTexture().getHeight());
	}

}
