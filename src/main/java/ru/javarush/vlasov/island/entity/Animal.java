package ru.javarush.vlasov.island.entity;

import java.util.HashMap;

public abstract class Animal {
    private final float WEIGHT;
    private final int SPECIES_PER_SPOT;
    private final int TRAVEL_SPEED;
    private final float FOOD_LIMIT;
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();


    public Animal(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, float FOOD_LIMIT) {
        this.WEIGHT = WEIGHT;
        this.SPECIES_PER_SPOT = SPECIES_PER_SPOT;
        this.TRAVEL_SPEED = TRAVEL_SPEED;
        this.FOOD_LIMIT = FOOD_LIMIT;
    }

    public HashMap<String, Integer> getCHANCE_TO_EAT() {
        return CHANCE_TO_EAT;
    }
}
