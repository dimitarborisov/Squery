package com.squary.game.Alisquare;

import com.badlogic.gdx.Game;
import com.squary.game.*;

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
    private boolean playerAlive = true;
    private int enemiesKilled = 0;

    public PhysicsHandler(GamePlayer _player, GameBoard _board){
        List<GameWall> walls = _board.getWalls();
        List<GameEnemy> enemies = _board.getEnemies();
		List<DamageArea> areas = _board.getAreas();
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

        for (GameEnemy enemy: enemies){
            if (Collision.SACheck(_player.getBody().bounds,enemy.getBody().bounds)) {
                playerAlive = false;
            }
        }
        ArrayList<GameEnemy> taggedToKill = new ArrayList<GameEnemy>();
        for (DamageArea area:areas){
            for (GameEnemy enemy:enemies){
                if (Collision.SACheck(area.getBody().bounds,enemy.getBody().bounds)) taggedToKill.add(enemy);
            }
        }
        for (GameEnemy enemy: taggedToKill){
            enemies.remove(enemy);
            enemiesKilled++;
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

    public boolean isPlayerAlive(){
        return playerAlive;
    }

    public int getEnemiesKilled(){
        return enemiesKilled;
    }
    
    public boolean isCollidingOnX() {
    	return this.collidingOnX;
    }
    
    public boolean isCollidingOnY() {
    	return this.collidingOnY;
    }
}
