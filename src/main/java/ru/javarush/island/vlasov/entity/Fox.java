package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Fox extends Predator {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Fox() {
        super(8, 30, 2, 2);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 40);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 60);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 70);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Fox();
    }

    @Override
    public String toString() {
        return "Fox";
    }
}
