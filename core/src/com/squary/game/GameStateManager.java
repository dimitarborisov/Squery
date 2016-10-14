package com.squary.game;

import java.util.Stack;

public class GameStateManager {
	private GameSquary game;
	private Stack<GameState> gameStates;
	
	public static int PLAY = 1;
	public static int SPLASH = 0;
	public static int OPTIONS = 2;
	
	public GameStateManager(GameSquary gameSquary){
		this.game = gameSquary;
		gameStates = new Stack<GameState>();
		
		gameStates.push(getState(SPLASH));
	}
	
	public GameSquary getGame(){ return game; }
	
	public void update(float dt){
		gameStates.peek().update(dt);
	}
	
	public void render(){
		gameStates.peek().render();
	}
	
	private GameState getState(int state){
		if(state == PLAY){
			return null;
		}
		
		if(state == SPLASH){
			return new Splash(this);
		}
		
		if(state == OPTIONS){
			return null;
		}
		
		return null;
	}

}
