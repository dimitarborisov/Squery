package com.squary.game.Alisquare;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class BoundingBox{
    public Vector2[] vertices;
    public String layer;

    public Vector2 position;

    public BoundingBox(Vector2[] _vertices, Vector2 _position){
        this(_vertices,_position,null);
    }

    public BoundingBox(Vector2[] _vertices, Vector2 _position, String _layer){
        vertices = _vertices;
        layer = _layer;
        position = _position;
    }

    public static float[] projectToAxis(BoundingBox _shape, Vector2 _axis){
        float min = _axis.dot(_shape.vertices[0]);
        float max = min;
        for (Vector2 vertex:_shape.vertices){
            float val = _axis.dot(vertex);
            min = Math.min(min,val);
            max = Math.max(max,val);
        }
        float[] result = new float[] {min,max};
        return result;
    }

    public static BoundingBox createRegularPolygon(int _sides, Vector2 _center, int _scale, float _angle) throws BoundingBoxException{
        if (_sides < 3) {
            throw new BoundingBoxException("Bounding boxes must have more than 2 sides");
        }
        float angleIncrement = (float)(2 * Math.PI) / _sides;
        float angleProgress = _angle;
        Vector2[] points = new Vector2[_sides];
        for (int i = 0; i< _sides;i++){
            points[i] = new Vector2((float)(_center.x + _scale * cos(angleProgress)),(float)(_center.y + _scale * sin(angleProgress)));
            angleProgress += angleIncrement;
        }
        return new BoundingBox(points,_center);
    }

    public static BoundingBox createRegularPolygon(int _sides, Vector2 _center, int _scale) throws BoundingBoxException{
        return createRegularPolygon(_sides,_center,_scale,0);
    }

    @Override
    public String toString(){
        String result = "BB:{";
        for (int i =0; i<vertices.length;i++ ){
            result += vertices[i].toString() + ",";
        }
        result += "}Layer:" + layer;
        return result;
    }

}
