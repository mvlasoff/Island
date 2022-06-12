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
        ExecutorService executorService = Executors.newFixedThreadPool(64);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(new SpotStatistics(spot), 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new SpotCleaner(spot), 500, 1000, TimeUnit.MILLISECONDS);
        //executorService.submit(new SpotCleaner(spot));

        for (Nature n : nature) {
            if (n instanceof Animal) {
                executorService.submit(new AnimalRunner((Animal) n, spot));
            } else if (n instanceof Plant) {
                executorService.submit(new PlantRunner((Plant) n, spot));
            }
        }


        try {
            Thread.currentThread().sleep(5000);
            executorService.shutdown();
            scheduledExecutorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdownNow();
        scheduledExecutorService.shutdownNow();
    }
}
