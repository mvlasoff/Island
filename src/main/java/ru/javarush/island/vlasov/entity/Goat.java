package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Goat extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Goat() {
        super(60, 140, 3, 10);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Goat();
    }

    @Override
    public String toString() {
        return "Goat";
    }
}
