package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class EndGame extends GameState {

	public static int SCORE = 0;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font12;
	InputProcessor inputProcessor;
	BitmapFont font;
	GlyphLayout layout;

	Sprite background;

	protected EndGame(GameStateManager gsm) {
		super(gsm);
		background = new Sprite(am.getTexture("background"));

		font = new BitmapFont(Gdx.files.internal("font/Zrinc.fnt"), Gdx.files.internal("font/Zrinc.png"), false);
		layout = new GlyphLayout(); //dont do this every frame! Store it as member
		layout.setText(font, "Final score: " + SCORE);
		
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				Play.STATE = -1;
				EndGame.this.getStateManager().setState(new FadeOutIn(EndGame.this.getStateManager(), EndGame.this,
						new Menu(EndGame.this.getStateManager()), false, false));
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
				EndGame.this.getStateManager().setState(new FadeOutIn(EndGame.this.getStateManager(), EndGame.this,
						new Menu(EndGame.this.getStateManager()), false, false));
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		sb.begin();
		background.draw(sb);

		// sprite.draw(batch);
		font.draw(sb, layout, (GameSquary.VWIDTH / 2) - layout.width / 2, (GameSquary.VHEIGHT / 2) + layout.height / 2);

		sb.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
