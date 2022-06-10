package ru.javarush.vlasov.island.entity;

public class Eagle extends Predator {
    public Eagle(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, float FOOD_LIMIT) {
        super(6, 20, 3, 1);
        getCHANCE_TO_EAT().put(Bear.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boa.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boar.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Buffalo.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Caterpillar.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Deer.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Duck.class.getCanonicalName(), 80);
        getCHANCE_TO_EAT().put(Fox.class.getCanonicalName(), 10);
        getCHANCE_TO_EAT().put(Goat.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Horse.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Mouse.class.getCanonicalName(), 90);
        getCHANCE_TO_EAT().put(Plant.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Rabbit.class.getCanonicalName(), 90);
        getCHANCE_TO_EAT().put(Sheep.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Wolf.class.getCanonicalName(), 0);
    }
}
