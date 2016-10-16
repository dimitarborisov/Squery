package com.squary.game;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class EndGame extends GameState {
	String hostname = "Unknown";
	InetAddress ip;
	InetAddress addr;
	public static int SCORE = 0;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	InputProcessor inputProcessor;
	BitmapFont font;
	GlyphLayout layout;

	Sprite background;
	Preferences prefs;
	
	protected EndGame(GameStateManager gsm) {
		super(gsm);
		background = new Sprite(am.getTexture("background"));

		font = new BitmapFont(Gdx.files.internal("font/Zrinc.fnt"), Gdx.files.internal("font/Zrinc.png"), false);
		layout = new GlyphLayout(); //dont do this every frame! Store it as member
		layout.setText(font, "Final score: " + SCORE);
		
		prefs = Gdx.app.getPreferences("HighScore");
		
		
		String[] scores = new String[4];
		int[] scoreMarks = new int[4];
		
		try {
			//IP address as name
			//ip = InetAddress.getLocalHost();
			//scores[3] = ip.getHostAddress().toString();
			
			//PC name as name
			
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    scores[3] = hostname;
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		scores[0] = prefs.getString("1st", "");
		scores[1] = prefs.getString("2nd", "");
		scores[2] = prefs.getString("3rd", "");
		
		scoreMarks[0] = prefs.getInteger("1", -1);
		scoreMarks[1] = prefs.getInteger("2", -1);
		scoreMarks[2] = prefs.getInteger("3", -1);
		scoreMarks[3] = SCORE;
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				if(scoreMarks[j] < scoreMarks[j+1]){
					int temp = scoreMarks[j];
					scoreMarks[j] = scoreMarks[j+1];
					scoreMarks[j+1] = temp;
					
					String tempS = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = tempS;
				}
			}
		}
		
		prefs.putString("1st", scores[0]);
		prefs.putString("2nd", scores[1]);
		prefs.putString("3rd", scores[2]);
		
		prefs.putInteger("1", scoreMarks[0]);
		prefs.putInteger("2", scoreMarks[1]);
		prefs.putInteger("3", scoreMarks[2]);
		prefs.flush();
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				Play.STATE = -1;
				if(keycode == Keys.ENTER){
					EndGame.this.getStateManager().setState(new FadeOutIn(EndGame.this.getStateManager(), EndGame.this,
							new Menu(EndGame.this.getStateManager()), false, false));
				}
				
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
