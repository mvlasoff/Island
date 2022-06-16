package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.Nature;
import com.javarush.island.vlasov.utility.RndGen;
import com.javarush.island.vlasov.utility.Sleeper;
import com.javarush.island.vlasov.entity.Animal;
import com.javarush.island.vlasov.entity.Plant;
import com.javarush.island.vlasov.entity.Spot;

import java.util.concurrent.*;

public class SpotRunner {
    private final Spot[][] spots;

    public SpotRunner(Spot[][] spots) {
        this.spots = spots;
    }

    public void runSpots() {
        ScheduledExecutorService animalExecService = Executors.newScheduledThreadPool(4);
        ScheduledExecutorService plantExecService = Executors.newScheduledThreadPool(4);
        ScheduledExecutorService statExecService = Executors.newScheduledThreadPool(4);
        ScheduledExecutorService cleanerExecService = Executors.newScheduledThreadPool(4);

        for (Spot[] spotArray : spots) {
            for (Spot spot : spotArray) {

                spot.makeNature();
                CopyOnWriteArrayList<Nature> nature = spot.getNature();

                statExecService.scheduleAtFixedRate(new SpotStatistics(spot), 0, 1000, TimeUnit.MILLISECONDS);
                //cleanerExecService.scheduleAtFixedRate(new SpotCleaner(spot), 500, 1000, TimeUnit.MILLISECONDS);

                for (Nature n : nature) {
                    if (n instanceof Animal) {
                        animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) n, spot, animalExecService),
                                0, 1000, TimeUnit.MILLISECONDS);
                    } else if (n instanceof Plant) {
                        plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) n, spot, plantExecService),
                                0, 1000, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }


        statExecService.scheduleAtFixedRate(new IslandStatistics(spots),0, 1000, TimeUnit.MILLISECONDS);

        Spot randomSpot = spots[RndGen.getRndNum(spots.length)][RndGen.getRndNum(spots[0].length)];
        randomSpot.getSpotStatistics().setTurnOn(true);


        Sleeper.sleep(10000);
        animalExecService.shutdown();
        plantExecService.shutdown();
        cleanerExecService.shutdown();
        statExecService.shutdown();

        Sleeper.sleep(1000);
        animalExecService.shutdownNow();
        plantExecService.shutdownNow();
        cleanerExecService.shutdownNow();
        statExecService.shutdownNow();
    }
}
