package com.squary.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameSquary implements ApplicationListener {
	SpriteBatch mainBatch;
	ShapeRenderer mainSR;

	float accumulator;
	private static final float STEP = 1/60f;
	private GameStateManager gsm;
	private OrthographicCamera cam;
	private OrthographicCamera hud;

	public static int VWIDTH = 600;
	public static int VHEIGHT = 600;
	public static String TITLE = "Squary";
	
	TextureManager manager;
	
	@Override
	public void create() {
		manager = new TextureManager();
		mainBatch = new SpriteBatch();
		mainSR = new ShapeRenderer();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, VWIDTH, VHEIGHT);
		
		hud = new OrthographicCamera();
		hud.setToOrtho(false, VWIDTH, VHEIGHT);
		
		
		manager.loadTexture("Logo", "rect4136.png");
		manager.loadTexture("player", "player.png");
		manager.loadTexture("background", "background.png");
		manager.loadTexture("locked_door", "lockDoor.png");
		manager.loadTexture("locker", "lock.png");
		
		gsm = new GameStateManager(this);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// accumulator += Gdx.graphics.getRawDeltaTime();
		accumulator += Gdx.graphics.getDeltaTime();
		while (accumulator >= STEP) {
			accumulator -= STEP;
			gsm.update(STEP);
			gsm.render();
		}

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	public OrthographicCamera getCam(){
		return cam;
	}
	
	public OrthographicCamera getHud(){
		return hud;
	}
	
	public SpriteBatch getSpriteBatch(){
		return mainBatch;
	}

	public ShapeRenderer getShapeRenderer(){
		return mainSR;
	}
	
	public TextureManager getTextureManager(){
		return manager;
	}
}
