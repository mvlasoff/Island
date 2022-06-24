package ru.javarush.island.vlasov.service;

import ru.javarush.island.vlasov.entity.Island;
import ru.javarush.island.vlasov.entity.Spot;

public class IslandRunner {
    private final Island island;

    public IslandRunner() {
        this.island = new Island();
    }

    public void runIsland() {
        Spot[][] spots = island.getSpots();
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j] = new Spot(i * 10 + j, island.getSpots());
            }
        }

        new SpotRunner(spots).runSpots();
    }
}
