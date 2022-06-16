package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.RndGen;
import ru.javarush.vlasov.island.utility.Sleeper;

import java.util.ListIterator;
import java.util.Scanner;
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

        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {


                spots[i][j].makeNature();
                CopyOnWriteArrayList<Nature> nature = spots[i][j].getNature();


                statExecService.scheduleAtFixedRate(new SpotStatistics(spots[i][j]), 0, 1000, TimeUnit.MILLISECONDS);
                //cleanerExecService.scheduleAtFixedRate(new SpotCleaner(spot), 500, 1000, TimeUnit.MILLISECONDS);

                for (Nature n : nature) {
                    if (n instanceof Animal) {
                        animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) n, spots[i][j], animalExecService),
                                0, 1000, TimeUnit.MILLISECONDS);
                    } else if (n instanceof Plant) {
                        plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) n, spots[i][j], plantExecService),
                                0, 1000, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }

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
