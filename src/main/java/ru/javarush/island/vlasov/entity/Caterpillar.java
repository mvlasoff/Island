package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Caterpillar extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Caterpillar() {
        super(0.01F, 1000, 0, 0);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Caterpillar();
    }

    @Override
    public String toString() {
        return "Caterpillar";
    }
}
