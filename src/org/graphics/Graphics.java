package org.graphics;

import org.resources.ImageResource;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics 
{
	private float r = 1, g = 1, b = 1, a = 1;
	private float rotation = 0;
	private GL2 gl;
	
	
	Graphics()
	{
		gl = EventListener.gl;
	}
	
	public void fillRect(float x, float y, float width, float height)
	{
		gl.glTranslatef(x + width / 2, y - height / 2, 0); //Translate the graphic context to the center of the rectangle
		gl.glRotatef(rotation, 0, 0, 1); //Rotation of the graphic context

		gl.glColor4f(r, g, b, a); //Set the color

		//Drawing those verteces
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(-width / 2, height / 2);
		gl.glVertex2f(width / 2, height / 2);
		gl.glVertex2f(width / 2, - height / 2);
		gl.glVertex2f(-width / 2, - height / 2);
		gl.glEnd();
		gl.glFlush();

		gl.glRotatef(-rotation, 0, 0, 1); //Rotate back to the initial rotation
		gl.glTranslatef(-(x + width / 2), -(y - height / 2), 0); //Translate back to the initial position
	}

	public void drawRect(float x, float y, float width, float height)
	{
		gl.glTranslatef(x + width / 2, y - height / 2, 0); //Translate the graphic context to the center of the rectangle
		gl.glRotatef(rotation, 0, 0, 1); //Rotation of the graphic context

		//Drawing those verteces
		gl.glColor4f(r, g, b, a); //Set the color
		gl.glBegin(GL2.GL_LINE_STRIP);
		gl.glVertex2f(-width / 2, height / 2);
		gl.glVertex2f(width / 2, height / 2);
		gl.glVertex2f(width / 2, - height / 2);
		gl.glVertex2f(-width / 2, - height / 2);
		gl.glEnd();
		gl.glFlush();

		gl.glRotatef(-rotation, 0, 0, 1); //Rotate back to the initial rotation
		gl.glTranslatef(-(x + width / 2), -(y - height / 2), 0); //Translate back to the initial position
	}

	public void drawImage(ImageResource image, float x, float y, float width, float height)
	{
		//Getting the texture and verifying that it exists
		Texture texture = image.getTexture();
		if(texture != null)
		{
			gl.glBindTexture(GL2.GL_TEXTURE_2D, texture.getTextureObject());
		}

		gl.glTranslatef(x + width / 2, y - height / 2, 0); //Translate the graphic context to the center of the rectangle
		gl.glRotatef(rotation, 0, 0, 1); //Rotation of the graphic context

		//Drawing those verteces
		gl.glColor4f(1, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(-width / 2, height / 2);

		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(width / 2, height / 2);

		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(width / 2, - height / 2);

		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(-width / 2, - height / 2);
		gl.glEnd();
		gl.glFlush();

		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0); //Make the texture appear
		gl.glRotatef(-rotation, 0, 0, 1); //Rotate back to the initial rotation
		gl.glTranslatef(-(x + width / 2), -(y - height / 2), 0); //Translate back to the initial position
	}

	public void drawImage(ImageResource image, float x, float y)
	{
		Texture texture = image.getTexture();

		if(texture != null)
		{
			drawImage(image, x, y, texture.getWidth(), texture.getHeight());
		}
	}


	public void translate(float x, float y)
	{
		gl.glTranslatef(x, y, 0);
	}
	
	
	public void setColor(float r1, float g1, float b1)
	{
		if(r1 < 1 && r1 > 0)
		{
			r = r1;
		}
		if(g1 < 1 && g1 > 0)
		{
			r = g1;
		}
		if(b1 < 1 && b1 > 0)
		{
			r = b1;
		}
	}
	
//	public void setColor(float r1, float g1, float b1 float a1)
//	{
//		setColor(r, g, b);
//		if(a1 < 1 && a1 > 0)
//		{
//			a = a1;
//		}
//	}
	
	public void setColor(Color color)
	{
		r = color.getR();
		g = color.getG();
		b = color.getB();
	}
	

}
