package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class EndGame extends GameState {

	public static int SCORE = 0;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font12;
	InputProcessor inputProcessor;
	
	Sprite background;
	
	protected EndGame(GameStateManager gsm) {
		super(gsm);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/myfont.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		
		font12 = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		
		background = new Sprite(am.getTexture("background"));
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				Play.STATE = -1;
				EndGame.this.getStateManager().setState(new FadeOutIn(EndGame.this.getStateManager(), EndGame.this, new Menu(EndGame.this.getStateManager()), false, false));
				
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
				EndGame.this.getStateManager().setState(new FadeOutIn(EndGame.this.getStateManager(), EndGame.this, new Menu(EndGame.this.getStateManager()), false, false));
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
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
