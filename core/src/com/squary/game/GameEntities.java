package com.squary.game;

public abstract class GameEntities {
	protected int x,y;
	protected boolean visible;
	protected GameSquary game;
	
	public GameEntities(GameSquary game){
		x = 0;
		y = 0;
		this.visible = true;
		this.game = game;
	}
	
	public abstract void render();
	public abstract void update(float dt);
}
