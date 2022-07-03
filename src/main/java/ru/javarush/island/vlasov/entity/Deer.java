package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Deer extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Deer() {
        super(300, 20, 4, 50);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Deer();
    }

    @Override
    public String toString() {
        return "Deer";
    }
}
