package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Buffalo extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Buffalo() {
        super(700, 10, 3, 100);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Buffalo();
    }

    @Override
    public String toString() {
        return "Buffalo";
    }
}
