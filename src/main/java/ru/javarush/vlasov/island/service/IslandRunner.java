package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Island;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.RndGen;

public class IslandRunner {
    private final Island island;

    public IslandRunner() {
        this.island = new Island();
    }

    public void runIsland() {
        Spot[][] spots = island.getSpots();
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j] = new Spot(i + j);
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
