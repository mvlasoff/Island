package ru.javarush.vlasov.island.entity;

import java.util.HashMap;
import java.util.Objects;

public class Bear extends Predator {
    public Bear(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, int FOOD_LIMIT) {
        super(500, 5, 2, 80);
        getCHANCE_TO_EAT().put(Boa.class.getCanonicalName(), 80);
        getCHANCE_TO_EAT().put(Boar.class.getCanonicalName(), 50);
        getCHANCE_TO_EAT().put(Buffalo.class.getCanonicalName(), 20);
        getCHANCE_TO_EAT().put(Caterpillar.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Deer.class.getCanonicalName(), 80);
        getCHANCE_TO_EAT().put(Duck.class.getCanonicalName(), 10);
        getCHANCE_TO_EAT().put(Eagle.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Fox.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Goat.class.getCanonicalName(), 70);
        getCHANCE_TO_EAT().put(Horse.class.getCanonicalName(), 40);
        getCHANCE_TO_EAT().put(Mouse.class.getCanonicalName(), 90);
        getCHANCE_TO_EAT().put(Plant.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Rabbit.class.getCanonicalName(), 80);
        getCHANCE_TO_EAT().put(Sheep.class.getCanonicalName(), 70);
        getCHANCE_TO_EAT().put(Wolf.class.getCanonicalName(), 0);

    }
}
