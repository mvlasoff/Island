package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Mouse extends Herbivore {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Mouse() {
        super(0.05F, 500, 1, 0.01F);
        CHANCE_TO_EAT.put(Bear.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Boa.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Boar.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Buffalo.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Caterpillar.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Deer.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Eagle.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Fox.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Goat.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Horse.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Plant.class.getCanonicalName(), 100);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Sheep.class.getCanonicalName(), 0);
        CHANCE_TO_EAT.put(Wolf.class.getCanonicalName(), 0);
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