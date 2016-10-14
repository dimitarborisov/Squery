package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Splash extends GameState {
	int x,y;
	
	protected Splash(GameStateManager gsm) {
		super(gsm);
		x = 0;
		y = 0;
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		x += 10;
		y += 10;
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();
		sb.setProjectionMatrix(cam.combined);
		sr.setProjectionMatrix(cam.combined);
		
		
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.WHITE);
		sr.circle(x, y, 10);
		sr.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
