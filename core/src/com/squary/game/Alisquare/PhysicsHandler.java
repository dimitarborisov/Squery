package com.squary.game.Alisquare;

import com.squary.game.GameBoard;
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
        List<GameEntities> walls = _board.getWalls();
        List<GameEntities> enemies = _board.getEnemies();
        collisions = new ArrayList<Collision>();

        for (GameEntities wall: walls){
            Vector2 col = Collision.AACheck(_player.body.bounds,wall.getBody().bounds);
            if (!col.equals(new Vector2(0,0))){
                _player.body.bounds.position.subtract(col);
            }
        }


    }
}
