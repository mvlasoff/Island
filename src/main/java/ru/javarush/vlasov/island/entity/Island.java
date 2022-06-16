package ru.javarush.vlasov.island.entity;

public class Island {
    private final Spot[][] spots = new Spot[100][20];

    public Spot[][] getSpots() {
        return spots;
    }
}
