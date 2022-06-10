package ru.javarush.vlasov.island.entity;

public class Caterpillar extends Herbivore {
    public Caterpillar(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, int FOOD_LIMIT) {
        super(0.01F, 1000, 0, 0);
        getCHANCE_TO_EAT().put(Bear.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boa.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boar.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Buffalo.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Deer.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Duck.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Eagle.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Fox.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Goat.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Horse.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Mouse.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Plant.class.getCanonicalName(), 100);
        getCHANCE_TO_EAT().put(Rabbit.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Sheep.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Wolf.class.getCanonicalName(), 0);
    }
}
