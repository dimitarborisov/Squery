package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Play extends GameState {
	public static int STATE = -1;

	GamePlayer player;
	GameWall[] gameWalls;
	GameDoor[] gameDoors;
	
	Sprite background;

	InputProcessor inputProcessor;

	protected Play(GameStateManager gsm) {
		super(gsm);
		
		//set background
		background = new Sprite(game.getTextureManager().getTexture("background"));
		background.setSize(600, 600);
		background.setX(0);
		background.setY(0);
		
		// setting up wall
		gameWalls = new GameWall[8];
		for (int i = 0; i < 8; i++) {
			gameWalls[i] = new GameWall(game);
		}

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

		// player
		player = new GamePlayer(game);

		// doors
		gameDoors = new GameDoor[4];
		for (int i = 0; i < 4; i++) {
			gameDoors[i] = new GameDoor(game);
		}
		// bottom
		gameDoors[0].setPos(260, 0);
		gameDoors[0].setSize(80, 20);

		// top
		gameDoors[1].setPos(260, 580);
		gameDoors[1].setSize(80, 20);

		// left
		gameDoors[2].setPos(0, 260);
		gameDoors[2].setSize(20, 80);

		// right
		gameDoors[3].setPos(580, 260);
		gameDoors[3].setSize(20, 80);

		// input processing
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

		for (int i = 0; i < 8; i++) {
			gameWalls[i].update(dt);
		}
		
		for (int i = 0; i < 4; i++) {
			gameDoors[i].update(dt);
		}

		
		if(player.getX() + player.getSize() >= GameSquary.VWIDTH){
			System.out.println("HIT RIGHT border");
		}
		
		if(player.getX() <= 0){
			System.out.println("HIT left border");
		}
		
		if(player.getY() <= 0){
			System.out.println("Hit the bottom");
		}
		
		if(player.getY() + player.getSize() >= GameSquary.VHEIGHT){
			System.out.println("Hit the top");
		}
		
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		
		//update the camera
		game.getCam().update();
		game.getSpriteBatch().setProjectionMatrix(game.getCam().combined);
		
		//render everything
		game.getSpriteBatch().begin();
		background.draw(game.getSpriteBatch());
		game.getSpriteBatch().end();
		player.render();
		
		for (int i = 0; i < 8; i++) {
			gameWalls[i].render();
		}
		
		for(int i = 0; i < 4; i++){
			gameDoors[i].render();
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
