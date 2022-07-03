package ru.javarush.island.vlasov.entity;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;


public abstract class Animal implements Nature {
    private final float WEIGHT;
    private final int SPECIES_PER_SPOT;
    private final int TRAVEL_SPEED;
    private final float FOOD_LIMIT;

    private final AtomicBoolean isDead = new AtomicBoolean(false);
    private volatile float full = 0;

    public Animal(float weight, int speciesPerSpot, int travelSpeed, float foodLimit) {
        this.WEIGHT = weight;
        this.SPECIES_PER_SPOT = speciesPerSpot;
        this.TRAVEL_SPEED = travelSpeed;
        this.FOOD_LIMIT = foodLimit;
    }

    public float getWeight() {
        return WEIGHT;
    }

    public int getSpeciesPerSpot() {
        return SPECIES_PER_SPOT;
    }

    public int getTravelSpeed() {
        return TRAVEL_SPEED;
    }

    public float getFoodLimit() {
        return FOOD_LIMIT;
    }

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
