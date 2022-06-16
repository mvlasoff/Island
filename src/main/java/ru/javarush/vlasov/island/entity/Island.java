package ru.javarush.vlasov.island.entity;

public class Island {
    private final Spot[][] spots = new Spot[10][2];

    public Spot[][] getSpots() {
        return spots;
    }
}
