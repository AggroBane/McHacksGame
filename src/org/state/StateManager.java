package org.state;

import org.graphics.Graphics;

public class StateManager 
{
	
	private MenuState menuState;
	private GameState gameState;
	
	private final StateType actualState = StateType.GAME;
	
	public void init()
	{	
		menuState = new MenuState();
		gameState = new GameState();
	}
	
	public void update(float delta)
	{
		switch(actualState)
		{
			case MENU: 
				menuState.update(delta);
				break;
			case GAME:
				gameState.update(delta);
				break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(actualState)
		{
			case MENU:
				menuState.render(g);
				break;
			case GAME:
				gameState.render(g);
				break;
		}
	}
}
