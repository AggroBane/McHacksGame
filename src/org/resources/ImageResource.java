package org.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.graphics.Renderer;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

public class ImageResource 
{
	private final String defaultPath = "noTexture.png";
	
	private Texture texture;
	
	private BufferedImage image;
	
	public ImageResource(String path)
	{
		URL url = this.getClass().getResource("/res/"+path);
		
		try 
		{
			image = ImageIO.read(url);
		} catch (IOException IOException1) //IOException 
		{
			IOException1.printStackTrace();
		} catch(IllegalArgumentException illegalPath)
		{
			url = this.getClass().getResource("/res/"+defaultPath);
			try 
			{
				image = ImageIO.read(url);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(image != null) image.flush();
	}
	
	public Texture getTexture()
	{
		if(image == null) return null;

		if(texture == null)
		{
			texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);
		}
		
		return texture;
	}

}
