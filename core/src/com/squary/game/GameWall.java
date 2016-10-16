package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

public class GameWall extends GameEntities {
	public RigidBody body;
	Sprite wallSprite;
	
	public GameWall(GameSquary game,int _size) {
		super(game);
		
		wallSprite = new Sprite(game.getTextureManager().getTexture("playwall"));
		body = new RigidBody(BoundingBox.createRegularPolygon(4,new Vector2(0,0),_size-5,(float)Math.PI/4),true,10,1);
        wallSprite.setSize(_size, _size);

	}


    public GameWall(GameSquary game,Vector2 _size,float _rotation) {
        super(game);

        wallSprite = new Sprite(game.getTextureManager().getTexture("wall"));
        body = new RigidBody(BoundingBox.createRegularPolygon(4,new Vector2(0,0),(int)_size.x-5,_rotation),true,10,1);
        wallSprite.setSize(_size.x, _size.y);

    }

	@Override
	public void render() {

		game.getSpriteBatch().begin();
		
		wallSprite.draw(game.getSpriteBatch());
		
		game.getSpriteBatch().end();

        if (GameSquary.debug == true){
            debugRender();
        }
	}

	private void debugRender(){
		game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);

        game.getShapeRenderer().setColor(1,0,0,0);
		game.getShapeRenderer().polygon(Vector2.toFloatArray(body.bounds.vertices,body.bounds.position));


		game.getShapeRenderer().end();
	}

	@Override
	public void update(float dt) {
		wallSprite.setX(body.bounds.position.x - (wallSprite.getWidth()/2));
		wallSprite.setY(body.bounds.position.y - (wallSprite.getHeight()/2));

	}

    @Override
    public RigidBody getBody() {
        return body;
    }
    
    public void setVisibility (boolean isVisible) {
    	this.visible = isVisible;
    }


    public void setPos(float x, float y){
		body.bounds.position.x = x;
		body.bounds.position.y = y;

	}
	
}
