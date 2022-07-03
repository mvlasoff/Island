package ru.javarush.island.vlasov.entity;

public class Island {
    private final Spot[][] spots = new Spot[50][10];

    public Spot[][] getSpots() {
        return spots;
    }
}
