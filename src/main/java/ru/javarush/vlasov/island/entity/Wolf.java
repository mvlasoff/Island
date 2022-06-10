package ru.javarush.vlasov.island.entity;

public class Wolf extends Predator {

    public Wolf(int WEIGHT, int SPECIES_PER_SPOT, int TRAVEL_SPEED, int FOOD_LIMIT) {
        super(50, 30, 3, 8);
        getCHANCE_TO_EAT().put(Bear.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boa.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Boar.class.getCanonicalName(), 15);
        getCHANCE_TO_EAT().put(Buffalo.class.getCanonicalName(), 10);
        getCHANCE_TO_EAT().put(Caterpillar.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Deer.class.getCanonicalName(), 15);
        getCHANCE_TO_EAT().put(Duck.class.getCanonicalName(), 40);
        getCHANCE_TO_EAT().put(Eagle.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Fox.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Goat.class.getCanonicalName(), 60);
        getCHANCE_TO_EAT().put(Horse.class.getCanonicalName(), 10);
        getCHANCE_TO_EAT().put(Mouse.class.getCanonicalName(), 80);
        getCHANCE_TO_EAT().put(Plant.class.getCanonicalName(), 0);
        getCHANCE_TO_EAT().put(Rabbit.class.getCanonicalName(), 60);
        getCHANCE_TO_EAT().put(Sheep.class.getCanonicalName(), 70);
    }
}
