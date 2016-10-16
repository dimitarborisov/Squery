package com.squary.game;

/**
 * Created by Alistair
 */
public abstract class DamageArea {
    int lifespan = 60;
    public void updateDecay(){
        lifespan--;
    };
    public void doDamage(GameEntities _entity){
        _entity.takeDamage();
    }

}
