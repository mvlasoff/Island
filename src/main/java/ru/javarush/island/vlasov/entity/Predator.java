package ru.javarush.island.vlasov.entity;

public abstract class Predator extends Animal {

    public Predator(float weight, int speciesPerSpot, int travelSpeed, float foodLimit) {
        super(weight, speciesPerSpot, travelSpeed, foodLimit);
    }
}
