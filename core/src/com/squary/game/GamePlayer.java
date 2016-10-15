package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GamePlayer extends GameEntities {


	private Sprite playerSprite;
	private int size = 20;
	private RigidBody body;
	
	public GamePlayer(GameSquary game) {
		super(game);

		playerSprite = new Sprite(game.getTextureManager().getTexture("player"));
		body = new RigidBody(BoundingBox.createRegularPolygon(4,new Vector2(290,290),size-5,(float)Math.PI/4),true,10,1);
		super.visible = true;

        playerSprite.setOriginCenter();
		playerSprite.setSize(size, size);
	}



	@Override
	public void render() {
        if (GameSquary.debug == true){
            debugRender();
        }
		game.getSpriteBatch().begin();
		
		playerSprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();
	}

	private void debugRender(){
        game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);

        game.getShapeRenderer().polygon(Vector2.toFloatArray(body.bounds.vertices,body.bounds.position));

        game.getShapeRenderer().end();
    }

	@Override
	public void update(float dt) {
        if (body != null && playerSprite != null){
            body.bounds.position.x += body.velocity.x;
            body.bounds.position.y += body.velocity.y;

			playerSprite.setX(body.bounds.position.x-(playerSprite.getWidth()/2));
			playerSprite.setY(body.bounds.position.y-(playerSprite.getHeight()/2));
        }
	}
	
	public float getDx(){
		return body.velocity.x;
	}
	
	public float getDy(){
		return body.velocity.y;
	}
	
	public void setDx(float x){
		body.velocity.x = x;
	}
	
	public void setDy(float y){
		body.velocity.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public int getSize(){
		return size;
	}

}
