package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Duck extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Duck() {
        super(1, 200, 4, 0.15F);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Duck();
    }

    @Override
    public String toString() {
        return "Duck";
    }
}
