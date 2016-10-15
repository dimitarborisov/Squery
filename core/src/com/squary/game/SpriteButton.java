package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteButton {

	
	Sprite buttonSprite;
	float width, height;
	float x, y;
	
	SpriteButton(Sprite sprite, float width, float height, float x, float y){
		buttonSprite = sprite;
		this.width = width;
		this.height = height;
	}
	
	public void update(float dt){
		buttonSprite.setX(x);
		buttonSprite.setY(y);
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		buttonSprite.draw(sb);
		sb.end();
	}
}
