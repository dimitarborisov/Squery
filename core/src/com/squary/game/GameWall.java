package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameWall extends GameEntities {

	Sprite wallSprite;
	float sizeX,sizeY;
	
	public GameWall(GameSquary game) {
		super(game);
		
		wallSprite = new Sprite(game.getTextureManager().getTexture("wall"));
		
	}

	@Override
	public void render() {
		game.getSpriteBatch().begin();
		
		wallSprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();

	}

	@Override
	public void update(float dt) {
		wallSprite.setX(x);
		wallSprite.setY(y);
		wallSprite.setSize(sizeX, sizeY);

	}

	public void setSizeX(float size){
		sizeX = size;
	}
	
	public void setSizeY(float size){
		sizeY = size;
	}

	
	public void setPos(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void setSize(float width, float height){
		this.sizeX = width;
		this.sizeY = height;
	}
	
}
