package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.Sleeper;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.*;

public class SpotRunner {
    private final Spot spot;


    public SpotRunner() {
        this.spot = new Spot();
    }

    public void runSpot() {
        spot.makeNature();
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        CopyOnWriteArrayList<Nature> oldNature = spot.getNature();

        ScheduledExecutorService animalExecService = Executors.newScheduledThreadPool(64);
        ScheduledExecutorService plantExecService = Executors.newScheduledThreadPool(64);
        ScheduledExecutorService statExecService = Executors.newScheduledThreadPool(64);
        ScheduledExecutorService cleanerExecService = Executors.newScheduledThreadPool(64);

        statExecService.scheduleAtFixedRate(new SpotStatistics(spot), 0, 1, TimeUnit.SECONDS);
        //cleanerExecService.scheduleAtFixedRate(new SpotCleaner(spot), 500, 1000, TimeUnit.MILLISECONDS);

        //do {
            for (Nature n : nature) {
                if (n instanceof Animal) {
                    animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) n, spot), 0, 1000, TimeUnit.MILLISECONDS);
                } else if (n instanceof Plant) {
                    plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) n, spot), 0, 1000, TimeUnit.MILLISECONDS);
                }
                //oldNature.add(n);
            }
            /*nature = spot.getNature();
            nature.removeAll(oldNature);
        } while (nature.isEmpty());*/


        Sleeper.sleep(5000);
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
