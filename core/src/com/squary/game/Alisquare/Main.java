package com.squary.game.Alisquare;

public class Main {

    public static void main(String[] args){
        try{
            BoundingBox triangle1 = BoundingBox.createRegularPolygon(3,new Vector2(0,0),1);
            BoundingBox triangle2 = BoundingBox.createRegularPolygon(3,new Vector2(1.4f,0),1,(float)Math.PI/7);
            System.out.println(triangle1);
            System.out.println(triangle2);
            System.out.println(Collision.checkCollision(triangle1,triangle2));
        } catch (BoundingBoxException e){
            System.out.println(e.getMessage());
        }
    }
}
