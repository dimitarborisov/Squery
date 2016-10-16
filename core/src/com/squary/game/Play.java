package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.PhysicsHandler;
import com.squary.game.Alisquare.Vector2;

public class Play extends GameState {
	public static int STATE = -1;

	private int score = 0;
	private GamePlayer player;
	private GameWall[] gameWalls;
	private GameBoard gameBoard;
	private GameDoor[] gameDoors;
	
	private float playerSpeed = 5;
	
	Sprite background;
	
	boolean uno = false;
	boolean dos = false;
	
	boolean up = false, down = false, left = false, right = false;
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
		for (int i = 0; i < 4; i++) {
			gameWalls[i] = new GameWall(game,new Vector2(260,20),(float)Math.PI/4);
            BoundingBox.scale(gameWalls[i].body.bounds,new Vector2(260,20));
		}
        for (int i = 4; i < 8; i++) {
            gameWalls[i] = new GameWall(game,new Vector2(20,260),(float)Math.PI/4);
            BoundingBox.scale(gameWalls[i].body.bounds,new Vector2(20,260));
        }
		gameBoard = new GameBoard(game);
		gameBoard.initialize();

		float wallspriteW = (gameWalls[0].wallSprite.getWidth()/2);
		float wallspriteH = (gameWalls[0].wallSprite.getHeight()/2);
		// bottom
		gameWalls[0].setPos(0 + wallspriteW, 0 + wallspriteH);

		gameWalls[1].setPos(340+ wallspriteW, 0+ wallspriteH);

		// top
		gameWalls[2].setPos(0+ wallspriteW, 580+ wallspriteH);

		gameWalls[3].setPos(340+ wallspriteW, 580+ wallspriteH);

		// left
		gameWalls[4].setPos(0+ wallspriteH, 0+ wallspriteW);

		gameWalls[5].setPos(0+ wallspriteH, 340+ wallspriteW);

		// right
		gameWalls[6].setPos(580+ wallspriteH, 0+ wallspriteW);

		gameWalls[7].setPos(580+ wallspriteH, 340+ wallspriteW);

		// player
		player = new GamePlayer(game);
		player.body.velocity = new Vector2(0,0);

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

		if(STATE == 1){
			player.body.bounds.position = new Vector2(30, (GameSquary.VHEIGHT / 2) - player.getSize() / 2);
		}
		if(STATE == 2){
			player.body.bounds.position = new Vector2(GameSquary.VWIDTH - 30, (GameSquary.VHEIGHT / 2) - player.getSize() / 2);
		}
		if(STATE == 3){
			player.body.bounds.position = new Vector2((GameSquary.VWIDTH / 2) - player.getSize() / 2, GameSquary.VHEIGHT - player.getSize() - 10);
		}
		if(STATE == 4){
			
			player.body.bounds.position = new Vector2((GameSquary.VWIDTH / 2) - player.getSize() / 2, 30);
		}
		
		// input processing
		inputProcessor = new InputProcessor() {
			
			@Override
			public boolean keyDown(int keycode) {

				if (keycode == Keys.D || keycode == Keys.RIGHT) {
					uno = true;
					player.setDx(player.getDx() + playerSpeed);
				}

				if (keycode == Keys.A || keycode == Keys.LEFT) {
					uno = true;
					player.setDx(player.getDx() - playerSpeed);
				}

				if (keycode == Keys.W || keycode == Keys.UP) {
					dos = true;
					player.setDy(player.getDy() + playerSpeed);
				}

				if (keycode == Keys.S || keycode == Keys.DOWN) {
					dos = true;
					player.setDy(player.getDy() - playerSpeed);
				}

				if (keycode == Keys.SPACE){
                    PlayerAttack tempAttack = new PlayerAttack(game);
                    gameBoard.damageAreas.add(tempAttack);
                    tempAttack.getBody().setPos(player.body.bounds.position);

                }

				return true;
			}

			@Override
			public boolean keyUp(int keycode) {
				if (keycode == Keys.D || keycode == Keys.RIGHT) {
					if(uno){
						player.setDx(player.getDx() - playerSpeed);
					}
					
				}

				if (keycode == Keys.A || keycode == Keys.LEFT) {
					if(uno){
						player.setDx(player.getDx() + playerSpeed);
					}
				}

				if (keycode == Keys.W || keycode == Keys.UP) {
					if(dos){
						player.setDy(player.getDy() - playerSpeed);
					}
					
				}

				if (keycode == Keys.S || keycode == Keys.DOWN) {
					if(dos){
						player.setDy(player.getDy() + playerSpeed);
					}

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
        //Collision checks
		PhysicsHandler handler = new PhysicsHandler(player,gameBoard);
		player.setIsCollidingOnX(handler.isCollidingOnX());
		player.setIsCollidingOnY(handler.isCollidingOnY());
		player.update(dt);

		for (int i = 0; i < 8; i++) {
			gameWalls[i].update(dt);
		}
		
		for (int i = 0; i < 4; i++) {
			gameDoors[i].update(dt);
		}

		gameBoard.update(dt);



		if(player.getX() + player.getSize() >= GameSquary.VWIDTH){
			//System.out.println("HIT RIGHT border");
			Play.STATE = 1;
			Gdx.input.setInputProcessor(null);

			getStateManager().setState(new RightToLeft(getStateManager(), this, new Play(getStateManager()), false, false));
			
		}
		
		if(player.getX() <= 0){
			//System.out.println("HIT left border");
			Play.STATE = 2;
			Gdx.input.setInputProcessor(null);
			getStateManager().setState(new LeftToRight(getStateManager(), this, new Play(getStateManager()), false, false));
		}
		
		if(player.getY() <= 0){
			//System.out.println("Hit the bottom");
			Play.STATE = 3;
			Gdx.input.setInputProcessor(null);
			getStateManager().setState(new BottomToTop(getStateManager(), this, new Play(getStateManager()), false, false));
		}
		
		if(player.getY() + player.getSize() >= GameSquary.VHEIGHT){
			//System.out.println("Hit the top");
			Play.STATE = 4;
			Gdx.input.setInputProcessor(null);
			getStateManager().setState(new TopToBottom(getStateManager(), this, new Play(getStateManager()), false, false));
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
				
		gameBoard.render();
		
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

	private void endGame(){
		EndGame.SCORE = score;
		getStateManager().setState(new FadeOutIn(getStateManager(), this, new EndGame(getStateManager()), false, false));
	}
}
