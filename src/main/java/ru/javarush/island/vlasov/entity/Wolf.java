package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Wolf extends Predator {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Wolf() {
        super(50, 30, 3, 8);
        CHANCE_TO_EAT.put(Boar.class.getCanonicalName(), 15);
        CHANCE_TO_EAT.put(Buffalo.class.getCanonicalName(), 10);
        CHANCE_TO_EAT.put(Deer.class.getCanonicalName(), 15);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 40);
        CHANCE_TO_EAT.put(Goat.class.getCanonicalName(), 60);
        CHANCE_TO_EAT.put(Horse.class.getCanonicalName(), 10);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 60);
        CHANCE_TO_EAT.put(Sheep.class.getCanonicalName(), 70);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Wolf();
    }

    @Override
    public String toString() {
        return "Wolf";
    }
}
