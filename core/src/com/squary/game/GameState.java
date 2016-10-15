package com.squary.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class GameState {
	protected GameStateManager gsm;
	protected GameSquary game;
	
	protected SpriteBatch sb;
	protected ShapeRenderer sr;
	
	protected OrthographicCamera cam;
	protected OrthographicCamera hud;
	protected TextureManager am;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		game = gsm.getGame();
		sb = game.getSpriteBatch();
		cam = game.getCam();
		hud = game.getHud();
		sr = game.getShapeRenderer();
		am = game.getTextureManager();
	}
	
	public GameStateManager getStateManager(){ return gsm; }
	
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();	

}
