package com.squary.game.Alisquare;

import com.squary.game.GameEntities;

public class Collision{

    GameEntities[] offenders;
    String flag;
    float overlap;
    Vector2 axis;

    public Collision(GameEntities offenderA, GameEntities offenderB,String _flag){
        offenders = new GameEntities[] {offenderA,offenderB};
    }

    public Collision(GameEntities offenderA, GameEntities offenderB){
        this(offenderA,offenderB,"none");
    }

    public static boolean SACheck(BoundingBox _shape1, BoundingBox _shape2){
        //record miniumum overlap
        float minOverlap = 0;
        Vector2 minAxis = new Vector2(0,0);

        //get axes
        Vector2[] axes = getAxes(_shape1,_shape2);
        //loop through each set of axes
        for (Vector2 axis: axes){
            //project both shapes and check overlap
            float[] minMax1 = BoundingBox.projectToAxis(_shape1,axis);
            float[] minMax2 = BoundingBox.projectToAxis(_shape2,axis);
            //if there's no overlap then the shapes are not colliding
            if (!(minMax1[0] <= minMax2[1] && minMax2[0] <= minMax1[1])){
                return false;
            } else {
                float currentOverlap = Math.min(minMax1[1], minMax2[1]) - Math.max(minMax1[0],minMax2[0]);
                currentOverlap = Math.abs(currentOverlap);
                if (minOverlap > currentOverlap){
                    minOverlap = currentOverlap;
                    minAxis = axis;
                }
            }
        }
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

    public static Vector2 AACheck(BoundingBox _shape1, BoundingBox _shape2){
        float xOverlap = 0;
        float yOverlap = 0;
        if(_shape1.rect && _shape2.rect){
            // check for existance of overlap
            float minX1 = _shape1.vertices[0].x+_shape1.position.x;
            float maxX1 = _shape1.vertices[0].x+_shape1.position.x;
            float minY1 = _shape1.vertices[0].y+_shape1.position.y;
            float maxY1 = _shape1.vertices[0].y+_shape1.position.y;
            for (Vector2 vertex: _shape1.vertices) {
                minX1 = Math.min(vertex.x,minX1);
                minY1 = Math.min(vertex.y,minY1);
                maxX1 = Math.max(vertex.x,maxX1);
                maxY1 = Math.max(vertex.y,maxY1);
            }
            float minX2 = _shape2.vertices[0].x+_shape2.position.x;
            float maxX2 = _shape2.vertices[0].x+_shape2.position.x;
            float minY2 = _shape2.vertices[0].y+_shape2.position.y;
            float maxY2 = _shape2.vertices[0].y+_shape2.position.y;
            for (Vector2 vertex: _shape2.vertices) {
                minX2 = Math.min(vertex.x,minX2);
                minY2 = Math.min(vertex.y,minY2);
                maxX2 = Math.max(vertex.x,maxX2);
                maxY2 = Math.max(vertex.y,maxY2);
            }

            if(maxX1 >= minX2 ){

            }

            //Check X axis overlap
            //if((minX1 <= maxX2 && minX2 <= maxX1)){
            //    xOverlap = maxX1-minX2;

           // }
            //Check Y axis overlap
            //if((minY1 <= maxY2 && minY2 <= maxY1)){
             //   yOverlap = maxY1-minY2;
            //}
        } else {
            throw new BoundingBoxException("Axis Aligned Collisions can only be between rectangles");
        }
        System.out.println(xOverlap+","+yOverlap);
        return new Vector2(xOverlap, yOverlap);
    }

}
