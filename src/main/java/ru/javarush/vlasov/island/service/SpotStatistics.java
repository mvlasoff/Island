package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class SpotStatistics implements Runnable {
    private final Spot spot;

    public SpotStatistics(Spot spot) {
        this.spot = spot;
    }

    @Override
    public void run() {
        int predatorCount = 0;
        int herbCount = 0;
        int plantCount = 0;
        int deadCount = 0;

        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        for (Nature species : nature) {
            if(species instanceof Predator && !species.isDead()) {
                predatorCount++;
            } else if (species instanceof Herbivore && !species.isDead()) {
                herbCount++;
            } else if (species instanceof Plant && !species.isDead()) {
                plantCount++;
            }
            if(species.isDead()) {
                deadCount++;
            }
        }
        System.out.println("Predators: " + predatorCount + " *** Herbivores: " + herbCount + " *** Plants: " + plantCount+ " *** Dead: " + deadCount);
    }
}
