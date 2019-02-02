package org.state;

public class StateManager {
	MenuState menuState;
	GameState gameState;
	private final StateType actualState = StateType.MENU;
	
	public void init(){
		menuState = new MenuState();
		gameState = new GameState();
	}
	
	public void update(float delta){
		switch(actualState){
		case MENU: 
			menuState.render();
		default:
			gameState.render();
		}
	}
	
	public void render(){
		switch(actualState){
		case MENU:
			menuState.render();
		default:
			gameState.render();
		}
	}
}
