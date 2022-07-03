package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Sheep extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Sheep() {
        super(70, 140, 3, 15);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Sheep();
    }

    @Override
    public String toString() {
        return "Sheep";
    }
}
