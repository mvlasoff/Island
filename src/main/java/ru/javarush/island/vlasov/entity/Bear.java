package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Bear extends Predator {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Bear() {
        super(500, 5, 2, 80);
        CHANCE_TO_EAT.put(Boa.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Boar.class.getCanonicalName(), 50);
        CHANCE_TO_EAT.put(Buffalo.class.getCanonicalName(), 20);
        CHANCE_TO_EAT.put(Deer.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 10);
        CHANCE_TO_EAT.put(Goat.class.getCanonicalName(), 70);
        CHANCE_TO_EAT.put(Horse.class.getCanonicalName(), 40);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Sheep.class.getCanonicalName(), 70);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    @Override
    public Nature getInstance() {
        return new Bear();
    }

    @Override
    public String toString() {
        return "Bear";
    }
}
