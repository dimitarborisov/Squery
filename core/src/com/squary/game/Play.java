package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.InputProcessor;

public class Play extends GameState {
	public static int STATE = -1;

	GamePlayer player;
	GameWall[] gameWalls;
	
	InputProcessor inputProcessor;

	protected Play(GameStateManager gsm) {
		super(gsm);
		gameWalls = new GameWall[10];
		player = new GamePlayer(game);

		

		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				if (keycode == Keys.D) {
					player.setDx(player.getDx() + 10);
				}

				if (keycode == Keys.A) {
					player.setDx(player.getDx() - 10);
				}

				if (keycode == Keys.W) {
					player.setDy(player.getDy() + 10);
				}

				if (keycode == Keys.S) {
					player.setDy(player.getDy() - 10);
				}

				return true;
			}

			@Override
			public boolean keyUp(int keycode) {
				if (keycode == Keys.D) {
					player.setDx(player.getDx() - 10);
				}

				if (keycode == Keys.A) {
					player.setDx(player.getDx() + 10);
				}

				if (keycode == Keys.W) {
					player.setDy(player.getDy() - 10);
				}

				if (keycode == Keys.S) {
					player.setDy(player.getDy() + 10);
				}

				return true;
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
	}

	@Override
	public void update(float dt) {
		player.update(dt);

	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);

		player.render();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
