package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameDoor extends GameEntities {

	boolean locked;
	Sprite doorSprite;
	Sprite lockSprite;
	float sizeX,sizeY;
	
	public GameDoor(GameSquary game) {
		super(game);
		locked = true;
		
		doorSprite = new Sprite(game.getTextureManager().getTexture("locked_door"));
	}

	@Override
	public void render() {
		game.getSpriteBatch().begin();
			
		if(locked){
			doorSprite.draw(game.getSpriteBatch());
		}
		
		game.getSpriteBatch().end();

	}

	@Override
	public void update(float dt) {
		doorSprite.setX(x);
		doorSprite.setY(y);
		doorSprite.setSize(sizeX, sizeY);

	}

	public void setSizeX(float size){
		sizeX = size;
	}
	
	public void setSizeY(float size){
		sizeY = size;
	}
	
	public void setPosY(float y){
		this.y = y;
	}
	
	public void setPosX(float x){
		this.x = x;
	}
	
	public void setPos(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void setSize(float width, float height){
		this.sizeX = width;
		this.sizeY = height;
	}
	
	public boolean getLocked(){
		return locked;
	}
	
	public void setLocked(boolean locked){
		this.locked = locked;
	}
}
