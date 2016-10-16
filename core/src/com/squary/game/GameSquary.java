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
	public static boolean debug = false;
	
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
		manager.loadTexture("wall", "walls.png");
		manager.loadTexture("enemy_stationary", "triangle.png");
		manager.loadTexture("logo2-background", "logo2-background.png");
		manager.loadTexture("logo2-e1", "logo2-e1.png");
		manager.loadTexture("logo2-e2", "logo2-e2.png");
		manager.loadTexture("logo2-e3", "logo2-e3.png");
		manager.loadTexture("yellow", "rect4964.png");
		manager.loadTexture("mainlogo", "MenuLogo.png");
		manager.loadTexture("playbutton", "rect4199.png");
		manager.loadTexture("playbutton2", "rect5904.png");
		manager.loadTexture("optionsButton", "g11199.png");
		manager.loadTexture("exitButton", "rect5909-7.png");
		manager.loadTexture("damage-circle","dmg_circle.png");
		
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
