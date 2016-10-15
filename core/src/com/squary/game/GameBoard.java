package com.squary.game;

import com.squary.game.Alisquare.Vector2;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
	
	private static final int SIZE = 27;
	private static final int WALLFACTOR = 15; // the higher this is the less walls there are
	private static final int ENEMYFACTOR = 15; // the higher this is the less enemies there are
//	private int [][] board; // not really gonna be used...
	//0 = empty; 1=wall, 2=enemy

	private List<GameWall> walls;
	private List<GameEnemy> enemies;
	private GamePlayer player;
	private GameSquary game;
	
	public GameBoard(GameSquary game) {
//		board  = new int[SIZE][SIZE];
		walls = new ArrayList<GameWall>();
		enemies = new ArrayList<GameEnemy>();
		this.game = game;
	}
	
	public void initialize() {
		for (int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				int rand1 = (int)Math.ceil(Math.random() * WALLFACTOR);
				int rand2 = (int)Math.ceil(Math.random() * ENEMYFACTOR);
				// render wall if value is 1
				if (rand1 == 1) {
					GameWall temp = new GameWall(this.game,new Vector2(20,20),(float)Math.PI/4);
					temp.setPos(i*20+30, j*20+30);
					walls.add(temp);
				}
				if (rand2 == 1) {
					GameEnemy temp = new GameEnemyStationary(this.game);
					temp.setPos(i*20+30, j*20+30);
					temp.setSize(20,20);
					enemies.add(temp);
				}
			}
		}
	}
	
	public void rerandomize() {
		walls.clear();
		enemies.clear();
		initialize();
	}

	public List<GameWall> getWalls(){
		return walls;
	}
	public List<GameEnemy> getEnemies(){
		return enemies;
	}
	public void update(float dt) {
		for (GameWall wall : walls){
			wall.update(dt);
		}
		for (GameEnemy enemy: enemies){
			enemy.update(dt);
		}
	}
	
	public void render() {
		for (GameWall wall : walls){
			wall.render();
		}
		for (GameEnemy enemy: enemies){
			enemy.render();
		}
	}
	
}