package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import aurelienribon.tweenengine.TweenManager;

public class Menu extends GameState {
	
	private final TweenManager tweenManager = new TweenManager();
	SpriteButton startButton;
	SpriteButton otherButton;
	SpriteButton exitButton;
	Sprite menuBackground;
	
	InputProcessor inputProcessor;
	
	protected Menu(GameStateManager gsm) {
		super(gsm);
		menuBackground = new Sprite(game.getTextureManager().getTexture("background"));
		
		startButton = new SpriteButton(new Sprite(game.getTextureManager().getTexture("logo2-e2")), 200, 50, 0, 150);
		otherButton = new SpriteButton(new Sprite(game.getTextureManager().getTexture("yellow")), 150, 50, 0, 100);
		exitButton = new SpriteButton(new Sprite(game.getTextureManager().getTexture("wall")), 100, 50, 0, 50);
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				
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
				Vector3 input = new Vector3(screenX, screenY, 0);
				cam.unproject(input);
				
				startButton.setClicked(input.x, input.y);
				otherButton.setClicked(input.x, input.y);
				exitButton.setClicked(input.x, input.y);
				
				return false;
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
		
	}

	@Override
	public void update(float dt) {
		tweenManager.update(dt);
		
		if(exitButton.isClicked()){
			Gdx.app.exit();
		}
		
		if(startButton.isClicked()){
			getStateManager().setState(new FadeOutIn(getStateManager(), this, new Play(getStateManager()), false, false));
		}
	}

	@Override
	public void render() {
		sb.begin();
		menuBackground.draw(sb);
		sb.end();
		
		startButton.render(sb);
		otherButton.render(sb);
		exitButton.render(sb);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
