package com.squary.game;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	HashMap<String, Texture> textureHash;
	
	public TextureManager(){
		textureHash = new HashMap<String, Texture>();
	
	}
	
	public void loadTexture(String name, String path){
		Texture t = new Texture(Gdx.files.internal(path));
		
		textureHash.put(name, t);
	}
	
	public Texture getTexture(String name){
		return textureHash.get(name);
	}
}
