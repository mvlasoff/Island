package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.Nature;
import com.javarush.island.vlasov.utility.Sleeper;
import com.javarush.island.vlasov.entity.Animal;
import com.javarush.island.vlasov.entity.Plant;
import com.javarush.island.vlasov.entity.Spot;

import java.util.concurrent.*;

public class SpotRunner {
    private final Spot[][] spots;
    private final int CORE_POOL_SIZE = 4;
    public static final int INITIAL_CLEANING_DELAY = 500;
    public static final int CLEANING_PERIOD = 1000;
    private final int NATURE_LIFE_PERIOD = 1;
    private final int LIFE_CYCLE = 360000;
    private final int FINAL_SHUTDOWN = 1100;

    public SpotRunner(Spot[][] spots) {
        this.spots = spots;
    }

    public void runSpots() {
        ScheduledExecutorService animalExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        ScheduledExecutorService plantExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        ScheduledExecutorService statExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        ScheduledExecutorService cleanerExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        for (Spot[] spotArray : spots) {
            for (Spot spot : spotArray) {

                spot.makeNature();
                CopyOnWriteArrayList<Nature> nature = spot.getNature();

                statExecService.scheduleAtFixedRate(new SpotStatistics(spot), 0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);
                cleanerExecService.scheduleAtFixedRate(new SpotCleaner(spot), INITIAL_CLEANING_DELAY, CLEANING_PERIOD, TimeUnit.MILLISECONDS);

                for (Nature species : nature) {
                    if (species instanceof Animal) {
                        animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) species, spot, animalExecService),
                                0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);
                    } else if (species instanceof Plant) {
                        plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) species, spot, plantExecService),
                                0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);
                    }
                }
            }
        }

        statExecService.scheduleAtFixedRate(new IslandStatistics(spots),0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);

        Sleeper.sleep(LIFE_CYCLE);
        animalExecService.shutdown();
        plantExecService.shutdown();
        cleanerExecService.shutdown();
        statExecService.shutdown();

        Sleeper.sleep(FINAL_SHUTDOWN);
        animalExecService.shutdownNow();
        plantExecService.shutdownNow();
        cleanerExecService.shutdownNow();
        statExecService.shutdownNow();
    }
}
