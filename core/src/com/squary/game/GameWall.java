package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameWall extends GameEntities {
	public RigidBody body;
	private Sprite wallSprite;
	float sizeX,sizeY;
	
	public GameWall(GameSquary game) {
		super(game);
		
		wallSprite = new Sprite(game.getTextureManager().getTexture("wall"));
		body = new RigidBody(BoundingBox.createRegularPolygon(4,new Vector2(290,290),(int)sizeX-5,(float)Math.PI/4),true,10,1);


	}

	@Override
	public void render() {
		if (GameSquary.debug == true){
			debugRender();
		}
		game.getSpriteBatch().begin();
		
		wallSprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();

	}

	private void debugRender(){
		game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);

		game.getShapeRenderer().polygon(Vector2.toFloatArray(body.bounds.vertices,body.bounds.position));

		game.getShapeRenderer().end();
	}

	@Override
	public void update(float dt) {
		wallSprite.setX(body.bounds.position.x);
		wallSprite.setY(body.bounds.position.y);
		wallSprite.setSize(sizeX, sizeY);

	}

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
