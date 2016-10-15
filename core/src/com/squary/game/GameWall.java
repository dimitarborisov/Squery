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
		// TODO Auto-generated method stub

	}

	public void setSizeX(float size){
		sizeX = size;
	}
	
	public void setSizeY(float size){
		sizeY = size;
	}

	
}
