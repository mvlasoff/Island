package ru.javarush.vlasov.island.entity;

import java.util.HashMap;

public abstract class Animal implements Nature {

    public abstract float getWeight();

    public abstract int getSpeciesPerSpot();

    public abstract int getTravelSpeed();

    public abstract float getFoodLimit();

    public abstract HashMap<String, Integer> getChanceToEat();

    public abstract boolean isDead();

    public abstract void setDead(boolean dead);

    public abstract int getFull();

    public abstract void setFull(int full);
}
