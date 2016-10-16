package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class HighScore extends GameState {

	Preferences prefs;
	InputProcessor inputProcessor;
	BitmapFont font;
	GlyphLayout layout[];
	GlyphLayout layoutH;
	Sprite background;
	
	protected HighScore(GameStateManager gsm) {
		super(gsm);
		
		layout = new GlyphLayout[3];
		layout[0] = new GlyphLayout();
		layout[1] = new GlyphLayout();
		layout[2] = new GlyphLayout();
		
		String[] scores = new String[4];
		int[] scoreMarks = new int[4];
		
		prefs = Gdx.app.getPreferences("HighScore");
		
		scores[0] = prefs.getString("1st", "");
		scores[1] = prefs.getString("2nd", "");
		scores[2] = prefs.getString("3rd", "");
		
		scoreMarks[0] = prefs.getInteger("1", -1);
		scoreMarks[1] = prefs.getInteger("2", -1);
		scoreMarks[2] = prefs.getInteger("3", -1);
		
		font = new BitmapFont(Gdx.files.internal("font/Zrinc.fnt"), Gdx.files.internal("font/Zrinc.png"), false);
		layoutH = new GlyphLayout();
		layoutH.setText(font, "HighScore");
		
		if(scoreMarks[0] == -1){
			layout[0].setText(font, "1. Empty :(");
		}else{
			layout[0].setText(font, "1. " + scores[0] + " - " + scoreMarks[0]);
		}
		
		if(scoreMarks[1] == -1){
			layout[1].setText(font, "2. Empty :(");
		}else{
			layout[1].setText(font, "2. " + scores[1] + " - " + scoreMarks[1]);
		}
		
		if(scoreMarks[2] == -1){
			layout[2].setText(font, "3. Empty :(");
		}else{
			layout[2].setText(font, "3. " + scores[2] + " - " + scoreMarks[2]);
		}
		
		background = new Sprite(am.getTexture("background"));
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				Play.STATE = -1;
				HighScore.this.getStateManager().setState(new FadeOutIn(HighScore.this.getStateManager(), HighScore.this,
						new Menu(HighScore.this.getStateManager()), false, false));
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
				HighScore.this.getStateManager().setState(new FadeOutIn(HighScore.this.getStateManager(), HighScore.this,
						new Menu(HighScore.this.getStateManager()), false, false));
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
		
		font.draw(sb, layoutH, (GameSquary.VWIDTH / 2) - layoutH.width / 2, (GameSquary.VHEIGHT - 10 - layoutH.height));
		font.draw(sb, layout[0], (GameSquary.VWIDTH / 2) - layout[0].width / 2, (GameSquary.VHEIGHT / 2) + layout[1].height / 2 + 100 - 50);
		font.draw(sb, layout[1], (GameSquary.VWIDTH / 2) - layout[1].width / 2, (GameSquary.VHEIGHT / 2) + layout[1].height / 2 - 50);
		font.draw(sb, layout[2], (GameSquary.VWIDTH / 2) - layout[2].width / 2, (GameSquary.VHEIGHT / 2) + layout[1].height / 2 - 100 - 50);
		
		sb.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
