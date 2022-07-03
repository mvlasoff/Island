package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Horse extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Horse() {
        super(400, 20, 4, 60);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Horse();
    }

    @Override
    public String toString() {
        return "Horse";
    }
}
