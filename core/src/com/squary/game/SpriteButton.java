package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteButton {

	boolean pressed = false;
	
	Sprite buttonSprite;
	
	SpriteButton(Sprite sprite, float width, float height, float x, float y){
		buttonSprite = sprite;
		sprite.setSize(width, height);
		sprite.setPosition(x, y);
	}
	
	public void update(float dt){
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		buttonSprite.draw(sb);
		sb.end();
	}
	
	void setClicked(float x, float y){
		if(x >= buttonSprite.getX() && x <= buttonSprite.getX()+buttonSprite.getWidth()){
			if(y >= buttonSprite.getY() && y <= buttonSprite.getY()+buttonSprite.getHeight()){
				pressed = true;
			}
		}
	}
	
	Sprite getSprite(){
		return buttonSprite;
	}
	
	boolean isClicked(){
		return pressed;
	}
}
