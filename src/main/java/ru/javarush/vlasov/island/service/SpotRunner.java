package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpotRunner {
    private final Spot spot;


    public SpotRunner() {
        this.spot = new Spot();
    }

    public void runSpot() {
        spot.makeNature();
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        do {
            for (Nature n : nature) {
                if (n instanceof Animal) {
                    executorService.execute(new AnimalRunner((Animal) n));
                }
                else if (n instanceof Plant) {
                    executorService.execute(new PlantRunner((Plant) n));
                }
            }
        } while (spot.getNature().size() > 0);
        executorService.shutdown();
    }
}
