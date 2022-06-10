package ru.javarush.vlasov.island.entity;

import java.util.HashMap;

public abstract class Herbivore extends Animal {
    public Herbivore(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, float FOOD_LIMIT) {
        super(WEIGHT, SPECIES_PER_SPOT, TRAVEL_SPEED, FOOD_LIMIT);
    }
}
