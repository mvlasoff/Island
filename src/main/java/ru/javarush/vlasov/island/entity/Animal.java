package ru.javarush.vlasov.island.entity;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Animal implements Nature {

    private AtomicBoolean isDead = new AtomicBoolean(false);
    private volatile float full = 0;

    public abstract float getWeight();

    public abstract int getSpeciesPerSpot();

    public abstract int getTravelSpeed();

    public abstract float getFoodLimit();

    public abstract HashMap<String, Integer> getChanceToEat();

    public boolean isDead() {
        return isDead.get();
    }

    public void setDead() {
        isDead.set(true);
    }

    public float getFull() {
        return full;
    }

    public void setFull(float full) {
        this.full = full;
    }
}
