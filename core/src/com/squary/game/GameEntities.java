package com.squary.game;

public abstract class GameEntities {
	protected boolean visible;
	protected GameSquary game;
	
	public GameEntities(GameSquary game){
		this.visible = true;
		this.game = game;
	}
	
	public abstract void render();
	public abstract void update(float dt);
}
