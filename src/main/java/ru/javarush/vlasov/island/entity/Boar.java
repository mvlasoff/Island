package ru.javarush.vlasov.island.entity;

public class Boar extends Herbivore {
    public Boar(float WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, int FOOD_LIMIT) {
        super(400, 50, 2, 50);
        getCHANCE_TO_EAT().put(Bear.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boa.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Buffalo.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Caterpillar.class.getCanonicalName(), 90);
        getCHANCE_TO_EAT().put(Deer.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Duck.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Eagle.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Fox.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Goat.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Horse.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Mouse.class.getCanonicalName(), 50);
        getCHANCE_TO_EAT().put(Plant.class.getCanonicalName(), 100);
        getCHANCE_TO_EAT().put(Rabbit.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Sheep.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Wolf.class.getCanonicalName(), 0);
    }
}
