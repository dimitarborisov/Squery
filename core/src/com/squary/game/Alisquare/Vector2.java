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
}
