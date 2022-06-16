package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.Island;
import com.javarush.island.vlasov.entity.Spot;

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

        /*Spot randomSpot = spots[RndGen.getRndNum(spots.length)][RndGen.getRndNum(spots[0].length)];
        randomSpot.getSpotStatistics().setTurnOn(true);*/

        new SpotRunner(spots).runSpots();

/*        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                Spot spot = spots[i][j];
                new SpotRunner(spot).runSpot();
            }
        }*/

    }
}
