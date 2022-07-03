package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Mouse extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Mouse() {
        super(0.05F, 500, 1, 0.01F);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Mouse();
    }

    @Override
    public String toString() {
        return "Mouse";
    }
}
