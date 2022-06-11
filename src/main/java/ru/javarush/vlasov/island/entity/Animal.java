package ru.javarush.vlasov.island.entity;

import java.util.HashMap;

public abstract class Animal {
    public abstract float getWeight();

    public abstract int getSpeciesPerSpot();

    public abstract int getTravelSpeed();

    public abstract float getFoodLimit();

    public abstract HashMap<String, Integer> getChanceToEat();
}
