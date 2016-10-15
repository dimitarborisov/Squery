package com.squary.game;

import com.squary.game.Alisquare.Vector2;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
	
	private static final int SIZE = 27;
	private static final int WALLFACTOR = 10; // the higher this is the less walls there are
//	private int [][] board; // not really gonna be used...
	//0 = empty; 1=wall, 2=enemy
	private List<GameEntities> walls;
	private List<GameEntities> enemies;
	private GamePlayer player;
	private GameSquary game;
	
	public GameBoard(GameSquary game) {
//		board  = new int[SIZE][SIZE];
		walls = new ArrayList<GameEntities>();
		enemies = new ArrayList<GameEntities>();

		this.game = game;
	}
	
	public void initialize() {
		for (int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				int rand = (int)Math.ceil(Math.random() * WALLFACTOR);
				// render wall if value is 1
				if (rand == 1) {
					GameWall temp = new GameWall(this.game,new Vector2(20,20),(float)Math.PI/4);
					temp.setPos(i*20+30, j*20+30);
					walls.add(temp);
				}
			}
		}
	}
	
	public void rerandomize() {
		walls.clear();
		enemies.clear();
		initialize();
	}

	public List<GameEntities> getWalls(){
		return walls;
	}
	public List<GameEntities> getEnemies(){
		return enemies;
	}
	public void update(float dt) {
		for (GameEntities wall : walls){
			wall.update(dt);
		}
	}
	
	public void render() {
		for (GameEntities wall : walls){
			wall.render();
		}
	}
	
}
