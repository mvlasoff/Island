package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Rabbit extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Rabbit() {
        super(2, 150, 2, 0.45F);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Rabbit();
    }

    @Override
    public String toString() {
        return "Rabbit";
    }
}
