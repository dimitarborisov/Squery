package com.squary.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class RightToLeft extends GameState{
	FrameBuffer bufferPrevious;
	FrameBuffer bufferNext;

	Sprite previousSprite;
	Sprite nextSprite;

	GameState previousState;
	GameState nextState;

	SpriteBatch transitionBatch;
	OrthographicCamera transitionCam;

	TweenCallback tweenCallback;
	private final TweenManager tweenManager = new TweenManager();

	public RightToLeft(GameStateManager m, GameState from, GameState to, boolean flipX, boolean flipY) {
		super(m);

		transitionBatch = new SpriteBatch();
		transitionCam = new OrthographicCamera();
		transitionCam.setToOrtho(true, GameSquary.VWIDTH, GameSquary.VHEIGHT);
		transitionCam.position.x = GameSquary.VWIDTH / 2;
		transitionCam.position.y = GameSquary.VHEIGHT / 2;
		transitionCam.update();

		bufferPrevious = new FrameBuffer(Pixmap.Format.RGBA8888, (int) GameSquary.VWIDTH, (int) GameSquary.VHEIGHT, false);
		bufferNext = new FrameBuffer(Pixmap.Format.RGBA8888, (int) GameSquary.VWIDTH, (int) GameSquary.VHEIGHT, false);

		// TWEEN SETTINGS
		Tween.setCombinedAttributesLimit(4);
		Tween.registerAccessor(Sprite.class, new TweenEngineSprite());

		this.previousState = from;
		this.nextState = to;

		// from sprite render
		
		bufferPrevious.begin();
		previousState.render();
		bufferPrevious.end();

		previousSprite = new Sprite(bufferPrevious.getColorBufferTexture());
		previousSprite.setPosition(0, 0);
		previousSprite.flip(flipX, flipY);

		// to sprite render
		nextState.update(1/60f);
		bufferNext.begin();
		nextState.render();
		bufferNext.end();

		nextSprite = new Sprite(bufferNext.getColorBufferTexture());
		nextSprite.setPosition(nextSprite.getWidth(), 0);
		nextSprite.flip(flipX, flipY);

		tweenCallback = new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				getGameStateManager().setState(getNextState());
			}
		};

		Tween.to(nextSprite, TweenEngineSprite.POS_XY, 0.8f).target(0, 0).delay(0.2f)
				// .ease(TweenEquations.easeOutBack)
				.setCallback(tweenCallback).setCallbackTriggers(TweenCallback.COMPLETE).start(tweenManager);
		
		Tween.to(previousSprite, TweenEngineSprite.POS_XY, 0.8f).target(-previousSprite.getWidth(), 0).delay(0.2f)
				// .ease(TweenEquations.easeOutBack)
				.start(tweenManager);
	}
	

	@Override
	public void update(float dt) {
		tweenManager.update(dt);

	}

	@Override
	public void render() {
		transitionBatch.disableBlending();
		transitionBatch.setProjectionMatrix(transitionCam.combined);

		transitionBatch.begin();
		previousSprite.draw(transitionBatch);
		nextSprite.draw(transitionBatch);
		transitionBatch.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public GameState getNextState() {
		return nextState;
	}

	public GameStateManager getGameStateManager() {
		return super.getStateManager();
	}
}
