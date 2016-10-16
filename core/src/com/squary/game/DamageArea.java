package com.squary.game;

/**
 * Created by Alistair
 */
public abstract class DamageArea extends GameEntities {
    public static final int INITIAL_LIFESPAN = 50;
    int lifespan = INITIAL_LIFESPAN;

    public DamageArea(GameSquary game) {
        super(game);
    }

    public void updateDecay(){
        lifespan--;
    };


}
