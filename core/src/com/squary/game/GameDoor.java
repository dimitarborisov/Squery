package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameDoor extends GameEntities {
	public RigidBody body;
	boolean locked;
	Sprite doorSprite;
	Sprite lockSprite;
	float sizeX,sizeY;
	
	public GameDoor(GameSquary game) {
		super(game);
		locked = true;
		
		doorSprite = new Sprite(game.getTextureManager().getTexture("locked_door"));
		body = new RigidBody(BoundingBox.createRegularPolygon(4,new Vector2(290,290),(int)sizeX-5,(float)Math.PI/4),true,10,1);

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
		if (this.visible){
			doorSprite.setAlpha(1);
		} else {
			doorSprite.setAlpha(0);
		}
		doorSprite.setX(body.bounds.position.x);
		doorSprite.setY(body.bounds.position.y);
		doorSprite.setSize(sizeX, sizeY);

	}

    @Override
    public RigidBody getBody() {
        //TODO
        return null;
    }

    public void setSizeX(float size){
		sizeX = size;
	}
	
	public void setSizeY(float size){
		sizeY = size;
	}
	
	public void setPosY(float y){
		body.bounds.position.y = y;
	}
	
	public void setPosX(float x){
		body.bounds.position.x = x;
	}
	
	public void setPos(float x, float y){
		body.bounds.position.x = x;
		body.bounds.position.y = y;
	}
	
	public void setSize(float width, float height){
		this.sizeX = width;
		this.sizeY = height;
	}
	
	public void setVisibility(boolean isVisible){
		this.visible = isVisible;
	}
	
	public boolean getLocked(){
		return locked;
	}
	
	public void setLocked(boolean locked){
		this.locked = locked;
	}
}
