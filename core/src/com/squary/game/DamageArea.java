package com.squary.game;

/**
 * Created by Alistair
 */
public abstract class DamageArea extends GameEntities {
    int lifespan = 60;

    public DamageArea(GameSquary game) {
        super(game);
    }

    public void updateDecay(){
        lifespan--;
    };


}
