package ru.javarush.vlasov.island.entity;

import java.util.HashMap;
import java.util.Objects;

public class Bear extends Predator {
    private final float WEIGHT = 500;
    private final int SPECIES_PER_SPOT = 5;
    private final int TRAVEL_SPEED = 2;
    private final float FOOD_LIMIT = 80;
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    private boolean isDead = false;

    public Bear() {
        CHANCE_TO_EAT.put(Boa.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Boar.class.getCanonicalName(), 50);
        CHANCE_TO_EAT.put(Buffalo.class.getCanonicalName(), 20);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Deer.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 10);
        CHANCE_TO_EAT.put(Eagle.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Fox.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Goat.class.getCanonicalName(), 70);
        CHANCE_TO_EAT.put(Horse.class.getCanonicalName(), 40);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Sheep.class.getCanonicalName(), 70);
        CHANCE_TO_EAT.put(Wolf.class.getCanonicalName(), 0);

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

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void setDead(boolean dead) {
        isDead = dead;
    }
}
