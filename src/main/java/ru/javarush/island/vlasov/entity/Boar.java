package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Boar extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Boar() {
        super(400, 50, 2, 50);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 50);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Boa();
    }

    @Override
    public String toString() {
        return "Boar";
    }
}
