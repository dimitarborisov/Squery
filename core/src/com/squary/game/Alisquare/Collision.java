package com.squary.game.Alisquare;

public class Collision{

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
            shape1Axes[i] = Vector2.normalize(Vector2.normal(_shape1.vertices[i].subtract(_shape1.vertices[i + 1 == _shape1.vertices.length ? 0 : i + 1])));
        }

        for (int i = 0; i < _shape1.vertices.length; i++){
            shape2Axes[i] = Vector2.normalize(Vector2.normal(_shape2.vertices[i].subtract(_shape2.vertices[i + 1 == _shape2.vertices.length ? 0 : i + 1])));
        }

        System.arraycopy(shape1Axes, 0, axes, 0, shape1Axes.length);
        System.arraycopy(shape2Axes, 0, axes, shape1Axes.length, shape2Axes.length);

        return axes;
    }
}
