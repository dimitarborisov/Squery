package com.squary.game;

import java.util.Random;
import java.util.Stack;

public class GameStateManager {
	private GameSquary game;
	private Stack<GameState> gameStates;

	public static int PLAY = 1;
	public static int SPLASH = 0;
	public static int OPTIONS = 2;
	public static int MENU = 3;

	public GameStateManager(GameSquary gameSquary) {
		this.game = gameSquary;
		gameStates = new Stack<GameState>();

		gameStates.push(getState(SPLASH));
	}

	public GameSquary getGame() {
		return game;
	}

	public void update(float dt) {
		gameStates.peek().update(dt);
	}

	public void render() {
		gameStates.peek().render();
	}

	public GameState getState(int state) {
		if (state == PLAY) {
			Play.STATE = -1;
			return new Play(this,1);
		}

		if (state == SPLASH) {
			return new Splash(this);
		}

		if (state == OPTIONS) {
			return null;
		}
		
		if (state == MENU) {
			return null;
		}

		return null;
	}

	public void setState(GameState state) {
		GameState g = gameStates.pop();
		g.dispose();
		gameStates.push(state);
	}
	
	public void setState(int state) {
		GameState g = gameStates.pop();
		g.dispose();
		gameStates.push(getState(state));
	}
}
