package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameEnemyStationary extends GameEnemy {
	
	public GameEnemyStationary(GameSquary game) {
		super(game);
		enemySprite = new Sprite(game.getTextureManager().getTexture("enemy_stationary"));
	}

	@Override
	public void update(float dt) {
		enemySprite.setX(body.bounds.position.x - 9);//enemySprite.getHeight() instead of 10
		enemySprite.setY(body.bounds.position.y - 7);//enemySprite.getWidth() instead of 10
		enemySprite.setSize(sizeX, sizeY);
	}

}
