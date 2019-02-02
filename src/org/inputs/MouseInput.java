package org.inputs;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInput implements MouseListener
{

	float mouseX, mouseY;
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{

	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseWheelMoved(MouseEvent e) 
	{
		
	}

	public float getMouseX() 
	{
		return mouseX;
	}

	public float getMouseY() 
	{
		return mouseY;
	}
}
