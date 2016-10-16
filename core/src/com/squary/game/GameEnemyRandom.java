package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameEnemyRandom extends GameEnemy {
	private static final int SPEED = 2;
	private double angleTheta; //angle of enemy (maths standirt)
	
	public GameEnemyRandom(GameSquary game) {
		super(game);
		angleTheta = Math.PI/2;
		enemySprite = new Sprite(game.getTextureManager().getTexture("enemy_stationary"));

	}

	@Override
	public void update(float dt) {
		// determine new position based on randomness
		double change = 0;
		if (Math.random()<0.3) {
			body.bounds.position.x += Math.cos(angleTheta)*SPEED;
			body.bounds.position.y += Math.sin(angleTheta)*SPEED;
		} else {
			change = (Math.random()-0.5)*Math.PI/15;	
			angleTheta += change;
	        enemySprite.setOriginCenter();
			enemySprite.rotate((float)Math.toDegrees(change));
//			enemySprite.rotate(10);
			//enemySprite.rotate((float)angleTheta);
//			this.body.bounds.rotate(new Vector2(0,0), change);
//			this.body.bounds.rotate(new Vector2(0,0), 10);
	        //enemySprite.setRotation(0.01f);
		}
		// if going outside of field, get the enemy to turn around
		float x = this.getBody().bounds.position.x;
		float y = this.getBody().bounds.position.y;
		if (x<35 || x>565 || y<35 || y>565){
			angleTheta += Math.PI;
			while (x<35 || x>565 || y<35 || y>565) {
				x = body.bounds.position.x += Math.cos(angleTheta);
				y = body.bounds.position.y += Math.sin(angleTheta);
			}
		}

        // render at new position
		enemySprite.setX(body.bounds.position.x - 9);//enemySprite.getHeight() instead of 10
		enemySprite.setY(body.bounds.position.y - 7);//enemySprite.getWidth() instead of 10
		enemySprite.setSize(sizeX, sizeY);
	}
	
}
