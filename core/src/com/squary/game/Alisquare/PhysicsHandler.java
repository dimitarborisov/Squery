package com.squary.game.Alisquare;

import com.squary.game.GameBoard;
import com.squary.game.GameEnemy;
import com.squary.game.GameEntities;
import com.squary.game.GamePlayer;
import com.squary.game.GameWall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alistair
 */
public class PhysicsHandler {
    public ArrayList<Collision> collisions;
    private boolean resolved = false;

    public PhysicsHandler(GamePlayer _player, GameBoard _board){
        List<GameWall> walls = _board.getWalls();
        List<GameEnemy> enemies = _board.getEnemies();
        collisions = new ArrayList<Collision>();

        for (GameEntities wall: walls){
            Vector2 col = Collision.AACheck(_player.body.bounds,wall.getBody().bounds);
            if (!col.equals(new Vector2(0,0))){
            	if (col.x>0 && col.x > Math.abs(col.y)){
            		_player.setDx(0);
//            		_player.body.bounds.position = 
//            				_player.body.bounds.position.add(new Vector2(col.x,0));
            	}
            	else if (col.x<0 && (-col.x) > Math.abs(col.y)) {
            		_player.setDx(0);
//            		_player.body.bounds.position =
//            				_player.body.bounds.position.add(new Vector2(0,col.y));
            	}
            	else if (col.y>0 && col.y>Math.abs(col.x) || col.y<0 && (-col.y)>Math.abs(col.x)){
            		_player.setDy(0);
            	}
            	else {
            		System.out.println("Wtf is going on>!");
            	}
                
            }
        }


    }
}
