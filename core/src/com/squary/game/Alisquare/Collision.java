package com.squary.game.Alisquare;

import com.squary.game.GameEntities;

public class Collision{

    GameEntities[] offenders;
    String flag;

    public Collision(GameEntities offenderA, GameEntities offenderB,String _flag){
        offenders = new GameEntities[] {offenderA,offenderB};
    }

    public Collision(GameEntities offenderA, GameEntities offenderB){
        this(offenderA,offenderB,"none");
    }

    public static boolean checkCollision(BoundingBox _shape1, BoundingBox _shape2){

        //get axes
        Vector2[] axes = getAxes(_shape1,_shape2);
        //loop through each set of axes
        for (Vector2 axis: axes){
            //project both shapes and check overlap
            float[] minMax1 = BoundingBox.projectToAxis(_shape1,axis);
            float[] minMax2 = BoundingBox.projectToAxis(_shape2,axis);
            //if there's no overlap then the shapes are not colliding
            if (!(minMax1[0] <= minMax2[1] && minMax2[0] <= minMax2[1])){
                return false;
            }
        }
        //if there is overlap on every axis then the shapes are colliding
        return true;
    }

    public static Vector2[] getAxes(BoundingBox _shape1, BoundingBox _shape2){
        Vector2[] axes = new Vector2[_shape1.vertices.length + _shape2.vertices.length];
        Vector2[] shape1Axes = new Vector2[_shape1.vertices.length];
        Vector2[] shape2Axes = new Vector2[_shape2.vertices.length];

        for (int i = 0; i < _shape1.vertices.length; i++){
            Vector2 current = _shape1.vertices[i].add(_shape1.position);
            Vector2 next = _shape1.vertices[i + 1 == _shape1.vertices.length ? 0 : i + 1].add(_shape1.position);
            shape1Axes[i] = Vector2.normalize(Vector2.normal(current.subtract(next)));
        }

        for (int i = 0; i < _shape1.vertices.length; i++){
            Vector2 current = _shape2.vertices[i].add(_shape1.position);
            Vector2 next = _shape2.vertices[i + 1 == _shape2.vertices.length ? 0 : i + 1].add(_shape1.position);
            shape2Axes[i] = Vector2.normalize(Vector2.normal(current.subtract(next)));
        }

        System.arraycopy(shape1Axes, 0, axes, 0, shape1Axes.length);
        System.arraycopy(shape2Axes, 0, axes, shape1Axes.length, shape2Axes.length);

        return axes;
    }
}
