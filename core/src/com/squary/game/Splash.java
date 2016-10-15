package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class Splash extends GameState {
	int x,y;
	InputProcessor inputProcessor;
	private final TweenManager tweenManager = new TweenManager();
	
	Sprite logo;
	
	protected Splash(GameStateManager gsm) {
		super(gsm);
		
		x = 10;
		y = 10;
		Tween.registerAccessor(Sprite.class, new TweenEngineSprite());
		logo = new Sprite(am.getTexture("Logo"));
		
		logo.setSize(20f, 20f);
		logo.setPosition(100, 100);
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				Splash.this.getStateManager().setState(GameStateManager.PLAY);
				
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				return true;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		Gdx.input.setInputProcessor(inputProcessor);
		
		Tween.to(logo, TweenEngineSprite.POS_XY, 1)
		.repeatYoyo(10, 1)
		.target(500,500)
		.ease(TweenEquations.easeInOutBack)
		.start(tweenManager);
	}

	@Override
	public void update(float dt) {
		tweenManager.update(dt);
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1,1,1,1);
		
		cam.update();
		sb.setProjectionMatrix(cam.combined);
		sr.setProjectionMatrix(cam.combined);
		
		
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.OLIVE);
		
		sr.end();
		
		sb.begin();
		logo.draw(sb);
		sb.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	
}
