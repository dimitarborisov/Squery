package com.squary.game.Alisquare;

/**
 * Created by Alistair
 */
public class RigidBody {
    public BoundingBox bounds;
    public boolean isStatic;
    public Vector2 velocity;
    public float elasticity;
    public float mass;


    public RigidBody(BoundingBox _box, boolean _static, float _mass, float _elasticity){
        mass = _mass;
        isStatic = _static;
        bounds = _box;
        elasticity = _elasticity;
    }

    public void resolveCollision(RigidBody _body1, RigidBody _body2){
        float totalMass = _body1.mass + _body2.mass;
        float newVelX1 =  (_body1.velocity.x * (_body1.mass - _body2.mass) + (2 * _body2.mass * _body2.velocity.x)) / totalMass;
        float newVelX2 =  (_body2.velocity.x * (_body2.mass - _body1.mass) + (2 * _body1.mass * _body1.velocity.x)) / totalMass;
        float newVelY1 =  (_body1.velocity.y * (_body1.mass - _body2.mass) + (2 * _body2.mass * _body2.velocity.y)) / totalMass;
        float newVelY2 =  (_body2.velocity.y * (_body2.mass - _body1.mass) + (2 * _body1.mass * _body1.velocity.y)) / totalMass;
        _body1.velocity = _body1.velocity.add(new Vector2(newVelX1,newVelY1));
        _body2.velocity = _body2.velocity.add(new Vector2(newVelX2,newVelY2));
    }
}
