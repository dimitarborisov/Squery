package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public abstract class GameEnemy extends GameEntities {

	protected RigidBody body;
	protected Sprite wallSprite;
	protected float sizeX,sizeY;
	
	public GameEnemy(GameSquary game) {
		super(game);
		sizeX=20;
		sizeY=20;
	}
	
	@Override
	public abstract void render() ;

	@Override
	public abstract void update(float dt);
	
	public void setSizeX(float size){
		sizeX = size;
	}
	
	public void setSizeY(float size){
		sizeY = size;
	}

	
	public void setPos(float x, float y){
		body.bounds.position.x = x;
		body.bounds.position.y= y;
	}
	
	public void setSize(float width, float height){
		this.sizeX = width;
		this.sizeY = height;
	}

}
