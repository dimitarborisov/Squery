package com.squary.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.squary.game.Alisquare.BoundingBox;
import com.squary.game.Alisquare.RigidBody;
import com.squary.game.Alisquare.Vector2;

/**
 * Created by Alistair
 */
public class PlayerAttack extends GameEntities implements DamageArea {
    private RigidBody body;
    private int scale;
    private Sprite circleSprite;

    public PlayerAttack(GameSquary game) {
        super(game);
        scale = 100;
        BoundingBox bB = BoundingBox.createRegularPolygon(8,new Vector2(0,0),scale);
        body = new RigidBody(bB,true,10,1);
        super.visible = true;

        circleSprite.setOriginCenter();
        circleSprite.setSize(scale, scale);
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

    }

    @Override
    public RigidBody getBody() {
        return body;
    }

    @Override
    public void updateDecay() {

    }

    @Override
    public void doDamage(GameEntities _entity) {

    }
}
