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

    public PhysicsHandler(GamePlayer _player, GameBoard _board){
        List<GameWall> walls = _board.getWalls();
        List<GameEnemy> enemies = _board.getEnemies();
        collisions = new ArrayList<Collision>();

        for (GameEntities wall: walls){
            if (Collision.checkCollision(_player.body.bounds,wall.getBody().bounds)){
                collisions.add(new Collision(_player, wall));
            }
        }
    }
}
