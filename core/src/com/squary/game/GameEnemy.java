package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class GameEnemy extends GameEntities {

	protected RigidBody body;
	protected Sprite enemySprite;
	protected float sizeX,sizeY;
	
	public GameEnemy(GameSquary game) {
		super(game);
		sizeX=20;
		sizeY=20;
		body = new RigidBody(BoundingBox.createRegularPolygon(3,new Vector2(0,0),(int)sizeX-9,(float)Math.PI/2),true,10,1);
	}
	
	@Override
	public void render() {
		if (GameSquary.debug == true){
			debugRender();
		}
		game.getSpriteBatch().begin();
		
		enemySprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();

	}

	private void debugRender(){
		game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);

		game.getShapeRenderer().polygon(Vector2.toFloatArray(body.bounds.vertices,body.bounds.position));

		game.getShapeRenderer().end();
	}
	
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

	public RigidBody getBody() {
		return body;
	}
}
