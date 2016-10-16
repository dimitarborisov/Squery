package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameEnemyCharging extends GameEnemy {
	private static final int SPEED = 7;
	private double angleTheta; //angle of enemy (maths standirt)
	private GamePlayer player;
	private int sleep;
	
	public GameEnemyCharging(GameSquary game, GamePlayer player) {
		super(game);
		angleTheta = Math.PI/2;
		enemySprite = new Sprite(game.getTextureManager().getTexture("enemy_charging"));
		body = new RigidBody(BoundingBox.createRegularPolygon(8,new Vector2(0,0),(int)sizeX-11,(float)Math.PI/2),true,10,1);
		this.player = player;
		sleep = (int)(Math.random()*120);
	}

	@Override
	public void update(float dt) {
		
		float playerX = this.player.getX();
		float playerY = this.player.getY();
		
		float enemyX = enemySprite.getX();
		float enemyY = enemySprite.getY();
		
		Vector2 changeVector = new Vector2(playerX-enemyX,playerY-enemyY);
		Vector2 changeVectorUnit = changeVector.mul(1/Vector2.magnitude(changeVector));
		
		if(sleep++ >= 120){
			body.bounds.position =body.bounds.position.add(changeVectorUnit.mul(SPEED));
			if (sleep==130) sleep = 0;
		}
//		// determine new position based on randomness
//		double change = 0;
//		if (Math.random()<0.3) {
//			body.bounds.position.x += Math.cos(angleTheta)*SPEED;
//			body.bounds.position.y += Math.sin(angleTheta)*SPEED;
//		} else {
//			change = (Math.random()-0.5)*Math.PI/15;	
//			angleTheta += change;
//	        enemySprite.setOriginCenter();
//			enemySprite.rotate((float)Math.toDegrees(change));
////			enemySprite.rotate(10);
//			//enemySprite.rotate((float)angleTheta);
////			this.body.bounds.rotate(new Vector2(0,0), change);
////			this.body.bounds.rotate(new Vector2(0,0), 10);
//	        //enemySprite.setRotation(0.01f);
//		}
		// if going outside of field, get the enemy to turn around
//		float x = this.getBody().bounds.position.x;
//		float y = this.getBody().bounds.position.y;
//		if (x<35 || x>565 || y<35 || y>565){
//			angleTheta += Math.PI;
//			while (x<35 || x>565 || y<35 || y>565) {
//				x = body.bounds.position.x += Math.cos(angleTheta);
//				y = body.bounds.position.y += Math.sin(angleTheta);
//			}
//		}

        // render at new position
		enemySprite.setOriginCenter();
		enemySprite.setX(body.bounds.position.x - 9);//enemySprite.getHeight() instead of 10
		enemySprite.setY(body.bounds.position.y -9);//enemySprite.getWidth() instead of 10
		enemySprite.setSize(sizeX, sizeY);
	}
	
}
