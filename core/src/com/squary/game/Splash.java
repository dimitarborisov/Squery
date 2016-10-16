package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class Splash extends GameState {
	int x,y;
	InputProcessor inputProcessor;
	private final TweenManager tweenManager = new TweenManager();

	//load audio
	final Sound splashSkipSound = Gdx.audio.newSound(Gdx.files.internal("ButtonClick3.wav"));
	
	Sprite logo, logoBox, logoBox0, logoBox1, logoBox2, logoBox3, logoBackground;
	
	protected Splash(GameStateManager gsm) {
		super(gsm);
		
		Tween.registerAccessor(Sprite.class, new TweenEngineSprite());
		Texture texture = am.getTexture("logo2-e1");
		
		logo = new Sprite(texture);
		
		logoBox = new Sprite(am.getTexture("logo2-e2"));
		logoBox0 = new Sprite(am.getTexture("logo2-e3"));
		logoBox1 = new Sprite(am.getTexture("logo2-e3"));
		logoBox2 = new Sprite(am.getTexture("logo2-e3"));
		logoBox3 = new Sprite(am.getTexture("logo2-e3"));
		logoBackground = new Sprite(am.getTexture("background"));
		
		//setup logo text
		logo.setPosition((GameSquary.VWIDTH / 2) - logo.getWidth() / 2, (GameSquary.VHEIGHT / 2) - logo.getHeight() / 2);
		logo.setAlpha(0);
		
		logoBox.setSize(60, 60);
		logoBox.setPosition((GameSquary.VWIDTH / 2) + logo.getWidth() / 2f, (GameSquary.VHEIGHT / 2) - logoBox.getWidth() / 2);
		logoBox.setAlpha(0);
		
		logoBox0.setSize(60, 60);
		logoBox0.setPosition((GameSquary.VWIDTH / 2) + logo.getWidth() / 2f, (GameSquary.VHEIGHT / 2) - logoBox.getWidth() / 2);
		logoBox0.setAlpha(0);
		
		logoBox1.setSize(60, 60);
		logoBox1.setPosition((GameSquary.VWIDTH / 2) + logo.getWidth() / 2f, (GameSquary.VHEIGHT / 2) - logoBox.getWidth() / 2);
		logoBox1.setAlpha(0);
		
		logoBox2.setSize(60, 60);
		logoBox2.setPosition((GameSquary.VWIDTH / 2) + logo.getWidth() / 2f, (GameSquary.VHEIGHT / 2) - logoBox.getWidth() / 2);
		logoBox2.setAlpha(0);
		
		logoBox3.setSize(60, 60);
		logoBox3.setPosition((GameSquary.VWIDTH / 2) + logo.getWidth() / 2f, (GameSquary.VHEIGHT / 2) - logoBox.getWidth() / 2);
		logoBox3.setAlpha(0);
		
		//setup logo background
		logoBackground.setSize(GameSquary.VWIDTH, GameSquary.VHEIGHT);
		logoBackground.setPosition(0, 0);
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				Splash.this.getStateManager().setState(new FadeOutIn(Splash.this.getStateManager(), Splash.this, new Menu(Splash.this.getStateManager()), false, false));
				splashSkipSound.play();
				
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				Splash.this.getStateManager().setState(new FadeOutIn(Splash.this.getStateManager(), Splash.this, new Menu(Splash.this.getStateManager()), false, false));
				return true;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		Gdx.input.setInputProcessor(inputProcessor);
		
		Tween.to(logo, TweenEngineSprite.ALPHA, 1f)
				.target(1)
				.delay(0.5f)
				.ease(TweenEquations.easeOutQuint)
				.start(tweenManager);
		
		Tween.to(logo, TweenEngineSprite.POS_XY, 1f)
				.targetRelative(-60, 0)
				.delay(1.5f)
				.ease(TweenEquations.easeOutQuint)
				.start(tweenManager);
		
		
		Tween.to(logoBox, TweenEngineSprite.ALPHA, 1f)
				.target(1)
				.delay(2.5f)
				.ease(TweenEquations.easeOutQuint)
				.start(tweenManager);
		
		Tween.to(logoBox0, TweenEngineSprite.ALPHA, 0.1f)
		.target(1)
		.delay(3.5f)
		.ease(TweenEquations.easeOutQuint)
		.start(tweenManager);
		
		Tween.to(logoBox1, TweenEngineSprite.ALPHA, 0.1f)
		.target(1)
		.delay(3.5f)
		.ease(TweenEquations.easeOutQuint)
		.start(tweenManager);
		
		Tween.to(logoBox2, TweenEngineSprite.ALPHA, 0.1f)
		.target(1)
		.delay(3.5f)
		.ease(TweenEquations.easeOutQuint)
		.start(tweenManager);
		
		Tween.to(logoBox3, TweenEngineSprite.ALPHA, 0.1f)
		.target(1)
		.delay(3.5f)
		.ease(TweenEquations.easeOutQuint)
		.start(tweenManager);
		
		//final animation
		Tween.to(logoBox0, TweenEngineSprite.POS_XY, 1f)
			.targetRelative(-40, -40)
			.delay(3.5f)
			.ease(TweenEquations.easeOutQuint)
			.start(tweenManager);
		
		Tween.to(logoBox1, TweenEngineSprite.POS_XY, 1f)
			.targetRelative(40, -40)
			.delay(3.7f)
			.ease(TweenEquations.easeOutQuint)
			.start(tweenManager);
		
		Tween.to(logoBox2, TweenEngineSprite.POS_XY, 1f)
		.targetRelative(40, 40)
			.delay(3.9f)
			.ease(TweenEquations.easeOutQuint)
			.start(tweenManager);
		
		Tween.to(logoBox3, TweenEngineSprite.POS_XY, 1f)
			.targetRelative(-40, 40)
			.delay(4.1f)
			.ease(TweenEquations.easeOutQuint)
			.start(tweenManager);
		
	}

	
	@Override
	public void update(float dt) {
		tweenManager.update(dt);
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1,1,1,1);
		
		cam.update();
		sb.setProjectionMatrix(cam.combined);
		sr.setProjectionMatrix(cam.combined);
		
		sb.begin();
		logoBackground.draw(sb);
		
		logo.draw(sb);
		logoBox0.draw(sb);
		logoBox1.draw(sb);
		logoBox2.draw(sb);
		logoBox3.draw(sb);
		
		logoBox.draw(sb);
		
		sb.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	
}
