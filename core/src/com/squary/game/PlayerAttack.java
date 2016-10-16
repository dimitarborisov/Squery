package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

/**
 * Created by Alistair
 */
public class PlayerAttack extends DamageArea {
    private RigidBody body;
    private int scale;
    private Sprite circleSprite;

    public PlayerAttack(GameSquary game) {
        super(game);
        circleSprite = new Sprite(game.getTextureManager().getTexture("damage-circle"));

        scale = 100;
        BoundingBox bB = BoundingBox.createRegularPolygon(10,new Vector2(0,0),scale/2);
        body = new RigidBody(bB,true,10,1);

        circleSprite.setSize(scale, scale);
        super.visible = true;
    }

    @Override
    public void render() {
        if (GameSquary.debug == true){
            debugRender();
        }
        game.getSpriteBatch().begin();

        circleSprite.draw(game.getSpriteBatch());

        game.getSpriteBatch().end();
    }

    private void debugRender(){
        game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);

        game.getShapeRenderer().setColor(0,0,1,0);
        game.getShapeRenderer().polygon(Vector2.toFloatArray(body.bounds.vertices,body.bounds.position));

        game.getShapeRenderer().end();
    }

    @Override
    public void update(float dt) {
        circleSprite.setX(body.bounds.position.x - (circleSprite.getWidth()/2));
        circleSprite.setY(body.bounds.position.y - (circleSprite.getHeight()/2));
    }

    @Override
    public RigidBody getBody() {
        return body;
    }

}
