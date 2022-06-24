package ru.javarush.island.vlasov.entity;

public abstract class Herbivore extends Animal {
    public Herbivore(float weight, int speciesPerSpot, int travelSpeed, float foodLimit) {
        super(weight, speciesPerSpot, travelSpeed, foodLimit);
    }
}
