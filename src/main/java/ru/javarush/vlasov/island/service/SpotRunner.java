package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;

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
        ExecutorService animalExecService = Executors.newFixedThreadPool(64);
        ExecutorService plantExecService = Executors.newFixedThreadPool(64);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(new SpotStatistics(spot), 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new SpotCleaner(spot), 500, 1000, TimeUnit.MILLISECONDS);

        for (Nature n : nature) {
            if (n instanceof Animal) {
                animalExecService.submit(new AnimalRunner((Animal) n, spot));
            } else if (n instanceof Plant) {
                plantExecService.submit(new PlantRunner((Plant) n, spot));
            }
        }


        try {
            Thread.currentThread().sleep(5000);
            animalExecService.shutdown();
            plantExecService.shutdown();
            scheduledExecutorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        animalExecService.shutdownNow();
        plantExecService.shutdownNow();
        scheduledExecutorService.shutdownNow();
    }
}
