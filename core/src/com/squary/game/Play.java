package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.InputProcessor;

public class Play extends GameState {
	public static int STATE = -1;

	GamePlayer player;
	GameWall[] gameWalls;
	GameBoard gameBoard;

	InputProcessor inputProcessor;

	protected Play(GameStateManager gsm) {
		super(gsm);

		// setting up wall
		gameWalls = new GameWall[8];
		for (int i = 0; i < 8; i++) {
			gameWalls[i] = new GameWall(game);
		}
		gameBoard = new GameBoard(game);
		gameBoard.initialize();

		// bottom
		gameWalls[0].setPos(0, 0);
		gameWalls[0].setSize(260, 20);

		gameWalls[1].setPos(340, 0);
		gameWalls[1].setSize(260, 20);

		// top
		gameWalls[2].setPos(0, 580);
		gameWalls[2].setSize(260, 20);

		gameWalls[3].setPos(340, 580);
		gameWalls[3].setSize(260, 20);

		// left
		gameWalls[4].setPos(0, 0);
		gameWalls[4].setSize(20, 260);

		gameWalls[5].setPos(0, 340);
		gameWalls[5].setSize(20, 260);

		// right
		gameWalls[6].setPos(580, 0);
		gameWalls[6].setSize(20, 260);

		gameWalls[7].setPos(580, 340);
		gameWalls[7].setSize(20, 260);

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

		gameWalls[0].update(dt);
		gameWalls[1].update(dt);

		gameWalls[2].update(dt);
		gameWalls[3].update(dt);

		gameWalls[4].update(dt);
		gameWalls[5].update(dt);
		
		gameWalls[6].update(dt);
		gameWalls[7].update(dt);
		
		gameBoard.update(dt);
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);

		player.render();
		gameWalls[0].render();
		gameWalls[1].render();

		gameWalls[2].render();
		gameWalls[3].render();

		gameWalls[4].render();
		gameWalls[5].render();
		
		gameWalls[6].render();
		gameWalls[7].render();
		
		gameBoard.render();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
