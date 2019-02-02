package org.graphics;

public enum Color 
{
	RED(1, 0, 0),
	GREEN(0, 1, 0),
	BLUE(0, 0, 1);
	
	private float r,g,b;
	
	
	Color(float r, float g, float b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}


	public float getR() 
	{
		return r;
	}


	public float getG() 
	{
		return g;
	}


	public float getB() 
	{
		return b;
	}
}
