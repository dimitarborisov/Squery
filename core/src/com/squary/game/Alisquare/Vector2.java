package com.squary.game.Alisquare;

public class Vector2 {

    public float x,y;


    public Vector2(float _x, float _y) {
        x = _x;
        y = _y;

    }

    public Vector2 subtract(Vector2 _vector){
        return new Vector2(x-_vector.x,y-_vector.y);
    }

    public float dot(Vector2 _vector){
        return ((x*_vector.x) + (y*_vector.y));
    }

    public Vector2 add(Vector2 _vector){
        return new Vector2(x+_vector.x,y+_vector.y);
    }

    public Vector2 mul(Vector2 _vector){
        return new Vector2(_vector.x*x,_vector.y*y);
    }

    public Vector2 mul(float _factor){
        return new Vector2(x*_factor,y*_factor);
    }


    public boolean equals(Vector2 _vector){
        if (x == _vector.x && y==_vector.y){
            return true;
        } else {
            return false;
        }

    }

    public static Vector2 normalize(Vector2 _vector){
        float mag = magnitude(_vector);
        return new Vector2(_vector.x/mag,_vector.y/mag);
    }

    public static Vector2 normal(Vector2 _vector){
        return new Vector2(-_vector.y,_vector.x);
    }

    public static float magnitude(Vector2 _vector){
        return (float)Math.sqrt(Math.pow(_vector.x,2)+Math.pow(_vector.y,2));
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public static float[] toFloatArray(Vector2[] _vertices){
        return toFloatArray(_vertices,new Vector2(0,0));
    }

    public static float[] toFloatArray(Vector2[] _vertices,Vector2 _translation) {
        float[] result = new float[_vertices.length*2];
        int i = 0;
        int j = 0;
        while (i < _vertices.length){
            result[j] = _vertices[i].x + _translation.x;
            result[j+1] = _vertices[i].y + _translation.y;
            i++;
            j=j+2;
        }
        return result;
    }
}
