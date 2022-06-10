package ru.javarush.vlasov.island.entity;

public abstract class Predator extends Animal {
    public Predator(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, float FOOD_LIMIT) {
        super(WEIGHT, SPECIES_PER_SPOT, TRAVEL_SPEED, FOOD_LIMIT);
    }
}
