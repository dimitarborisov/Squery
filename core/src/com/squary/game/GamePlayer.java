package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class GamePlayer extends GameEntities {
	
	private Sprite playerSprite;
	private int size = 20;
	private float dx,dy;
	
	public GamePlayer(GameSquary game) {
		super(game);
		
		dx = 0;
		dy = 0;
		
		playerSprite = new Sprite(game.getTextureManager().getTexture("player"));
		super.visible = true;
		x = 290;
		y = 290;
		
		playerSprite.setSize(size, size);
		playerSprite.setX(x);
		playerSprite.setY(y);
	}

	@Override
	public void render() {
		game.getSpriteBatch().begin();
		
		playerSprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();
	}

	@Override
	public void update(float dt) {
		x += dx;
		y += dy;
		
		playerSprite.setX(x);
		playerSprite.setY(y);

	}
	
	public float getDx(){
		return dx;
	}
	
	public float getDy(){
		return dy;
	}
	
	public void setDx(float x){
		dx = x;
	}
	
	public void setDy(float y){
		dy = y;
	}

}
