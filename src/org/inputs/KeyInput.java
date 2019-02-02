package org.inputs;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener
{

	private boolean[] keyDown = new boolean[256];
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		keyDown[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
        if( !e.isPrintableKey() || e.isAutoRepeat() ) return;
        keyDown[e.getKeyCode()] = false;
	}
	
	public boolean isKeyDown(int keyCode)
	{
		return keyDown[keyCode];
	}

}
