package com.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Horse extends Herbivore {
    private final float WEIGHT = 400;
    private final int SPECIES_PER_SPOT = 20;
    private final int TRAVEL_SPEED = 4;
    private final float FOOD_LIMIT = 60;
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Horse() {
        CHANCE_TO_EAT.put(Bear.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Boa.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Boar.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Buffalo.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Deer.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Eagle.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Fox.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Goat.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Sheep.class.getCanonicalName(), 0);
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

    public Nature getInstance() {
        return new Horse();
    }
}