package com.squary.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class Menu extends GameState {
	
	private final TweenManager tweenManager = new TweenManager();
	SpriteButton startButton;
	SpriteButton otherButton;
	SpriteButton exitButton;
	Sprite menuBackground;
	Sprite logoSprite;
	Sprite playButton;
	Sprite optionsButton;
	Sprite exitButtonSprite;
	
	InputProcessor inputProcessor;
	
	protected Menu(GameStateManager gsm) {
		super(gsm);
		menuBackground = new Sprite(game.getTextureManager().getTexture("background"));
		logoSprite = new Sprite(game.getTextureManager().getTexture("mainlogo"));
		logoSprite.setPosition(GameSquary.VWIDTH, GameSquary.VHEIGHT);
		logoSprite.setAlpha(1);
		logoSprite.setOriginCenter();
		
		Texture texture = game.getTextureManager().getTexture("playbutton2");
		//texture.setFilter(TextureFilter.MipMapLinearLinear, TextureFilter.MipMapLinearLinear);
		playButton = new Sprite(texture);
		playButton.setSize(36, 36);
		playButton.setPosition(-40, 157);
		
		texture = game.getTextureManager().getTexture("optionsButton");
		//texture.setFilter(TextureFilter.MipMapLinearLinear, TextureFilter.MipMapLinearLinear);
		optionsButton = new Sprite(texture);
		optionsButton.setSize(36, 36);
		optionsButton.setPosition(-40, 107);
		
		texture = game.getTextureManager().getTexture("exitButton");
		//texture.setFilter(TextureFilter.MipMapLinearLinear, TextureFilter.MipMapLinearLinear);
		exitButtonSprite = new Sprite(texture);
		exitButtonSprite.setSize(36, 36);
		exitButtonSprite.setPosition(-40, 57);
		
		startButton = new SpriteButton(new Sprite(game.getTextureManager().getTexture("logo2-e2")), 200, 50, -200, 150);
		otherButton = new SpriteButton(new Sprite(game.getTextureManager().getTexture("yellow")), 150, 50, -150, 100);
		exitButton = new SpriteButton(new Sprite(game.getTextureManager().getTexture("wall")), 100, 50, -100, 50);
		
		
		Tween.registerAccessor(Sprite.class, new TweenEngineSprite());
		
		Tween.to(exitButton.getSprite(), TweenEngineSprite.POS_XY, 1.5f)
				.targetRelative(100, 0)
				.delay(0.5f)
				.ease(TweenEquations.easeOutCubic)
				.start(tweenManager);
		
		Tween.to(otherButton.getSprite(), TweenEngineSprite.POS_XY, 1.5f)
				.targetRelative(150, 0)
				.delay(0.6f)
				.ease(TweenEquations.easeOutCubic)
				.start(tweenManager);
		
		Tween.to(startButton.getSprite(), TweenEngineSprite.POS_XY, 1.5f)
				.targetRelative(200, 0)
				.delay(0.7f)
				.ease(TweenEquations.easeOutCubic)
				.start(tweenManager);
		
		Tween.to(playButton, TweenEngineSprite.POS_XY, 1.5f)
				.targetRelative(190, 0)
				.delay(0.8f)
				.ease(TweenEquations.easeOutCubic)
				.start(tweenManager);
		
		Tween.to(optionsButton, TweenEngineSprite.POS_XY, 1.5f)
				.targetRelative(140, 0)
				.delay(0.7f)
				.ease(TweenEquations.easeOutCubic)
				.start(tweenManager);
		
		Tween.to(exitButtonSprite, TweenEngineSprite.POS_XY, 1.5f)
				.targetRelative(90, 0)
				.delay(0.6f)
				.ease(TweenEquations.easeOutCubic)
				.start(tweenManager);
		
		Tween.to(logoSprite, TweenEngineSprite.POS_XY, 3f)
				.target(200, 200)
				.delay(2.2f)
				.ease(TweenEquations.easeOutBack)
				.start(tweenManager);
		
		
		inputProcessor = new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				
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
				Vector3 input = new Vector3(screenX, screenY, 0);
				cam.unproject(input);
				
				startButton.setClicked(input.x, input.y);
				otherButton.setClicked(input.x, input.y);
				exitButton.setClicked(input.x, input.y);
				
				return false;
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
		
	}

	@Override
	public void update(float dt) {
		tweenManager.update(dt);
		logoSprite.rotate(0.1f);
		
		if(exitButton.isClicked()){
			Gdx.app.exit();
		}
		
		if(startButton.isClicked()){
			getStateManager().setState(new FadeOutIn(getStateManager(), this, new Play(getStateManager()), false, false));
		}
	}

	@Override
	public void render() {
		sb.begin();
		menuBackground.draw(sb);
		logoSprite.draw(sb);
		sb.end();
		
		startButton.render(sb);
		otherButton.render(sb);
		exitButton.render(sb);
		
		sb.begin();
		playButton.draw(sb);
		exitButtonSprite.draw(sb);
		optionsButton.draw(sb);
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
