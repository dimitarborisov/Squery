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
    private boolean collidingOnX;
    private boolean collidingOnY;

    public PhysicsHandler(GamePlayer _player, GameBoard _board){
        List<GameWall> walls = _board.getWalls();
        List<GameEnemy> enemies = _board.getEnemies();
        collisions = new ArrayList<Collision>();
        collidingOnX = false;
        collidingOnY = false;

        if (enemies.isEmpty()) {
	        // Bottom
	    	if (_player.getY()<35 && 
	        		(_player.getX()<270 || _player.getX()>330)){
	    		if(_player.getDy()<0) collidingOnY = true;
	        }
	    	// Top
	    	if (_player.getY()>565 && 
	        		(_player.getX()<270 || _player.getX()>330)){
	        	if(_player.getDy()>0) collidingOnY = true;
	        }
	    	// Left
	        if (_player.getX()<35 && 
	        		(_player.getY()<270 || _player.getY()>330)){
	        	if(_player.getDx()<0) collidingOnX = true;
	        }
	        // Right
	        if (_player.getX()>565 && 
	        		(_player.getY()<270 || _player.getY()>330)){
	        	if(_player.getDx()>0) collidingOnX = true;
	        }
        } else {
        	// Bottom
        	if (_player.getY()<35){ 
        		if(_player.getDy()<0) collidingOnY = true;
            }
        	// Top
        	if (_player.getY()>565) {
            	if(_player.getDy()>0) collidingOnY = true;
            }
        	// Left
            if (_player.getX()<35) {
            	if(_player.getDx()<0) collidingOnX = true;
            }
            // Right
            if (_player.getX()>565) {
            	if(_player.getDx()>0) collidingOnX = true;
            }
        }

        for (GameEntities wall: walls){
            Vector2 col = Collision.AACheck(_player.body.bounds,wall.getBody().bounds);
            if (!col.equals(new Vector2(0,0))){
            	if (col.x>0 && col.x >= Math.abs(col.y)){
            		if (_player.getDx()<0) collidingOnX = true;
//            		_player.body.bounds.position = 
//            				_player.body.bounds.position.add(new Vector2(col.x,0));
            	}
            	else if (col.x<0 && (-col.x) >= Math.abs(col.y)) {
            		if (_player.getDx()>0) collidingOnX = true;
//            		_player.body.bounds.position =
//            				_player.body.bounds.position.add(new Vector2(0,col.y));
            	}
            	else if (col.y>0 && col.y>=Math.abs(col.x)){
            		if (_player.getDy()<0) collidingOnY = true;
            	}	
            	else if (col.y<0 && (-col.y)>=Math.abs(col.x)){
            		
            		if (_player.getDy()>0) collidingOnY = true;
            	}
            	else {
            		System.out.println("Wtf is going on>!");
            	}
                
            }
        }
    }
    
    public boolean isCollidingOnX() {
    	return this.collidingOnX;
    }
    
    public boolean isCollidingOnY() {
    	return this.collidingOnY;
    }
}
