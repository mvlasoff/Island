package ru.javarush.vlasov.island.entity;

public class Fox extends Predator {
    public Fox(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, float FOOD_LIMIT) {
        super(8, 30, 2, 2);
        getCHANCE_TO_EAT().put(Bear.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boa.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boar.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Buffalo.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Caterpillar.class.getCanonicalName(), 40);
        getCHANCE_TO_EAT().put(Deer.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Duck.class.getCanonicalName(), 60);
        getCHANCE_TO_EAT().put(Eagle.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Goat.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Horse.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Mouse.class.getCanonicalName(), 90);
        getCHANCE_TO_EAT().put(Plant.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Rabbit.class.getCanonicalName(), 70);
        getCHANCE_TO_EAT().put(Sheep.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Wolf.class.getCanonicalName(), 0);
    }
}
