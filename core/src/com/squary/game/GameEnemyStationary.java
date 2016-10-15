package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameEnemyStationary extends GameEnemy {
	protected Sprite enemySprite;
	
	public GameEnemyStationary(GameSquary game) {
		super(game);
		enemySprite = new Sprite(game.getTextureManager().getTexture("enemy_stationary"));
		body = new RigidBody(BoundingBox.createRegularPolygon(3,new Vector2(0,0),(int)sizeX-5,(float)Math.PI/4),true,10,1);
	}

	@Override
	public void render() {
//		if (GameSquary.debug == true){
//			debugRender();
//		}
		game.getSpriteBatch().begin();
		
		enemySprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();

	}

//	private void debugRender(){
//		game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);
//
//		game.getShapeRenderer().polygon(Vector2.toFloatArray(body.bounds.vertices,body.bounds.position));
//
//		game.getShapeRenderer().end();
//	}
	
	@Override
	public void update(float dt) {
		enemySprite.setX(body.bounds.position.x);
		enemySprite.setY(body.bounds.position.y);
		enemySprite.setSize(sizeX, sizeY);

	}


}
