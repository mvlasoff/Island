package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.*;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SpotStatistics implements Runnable {
    private final Spot spot;

    private boolean turnOn = false;

   /* private AtomicInteger predatorCount = new AtomicInteger(0);
    private AtomicInteger herbCount = new AtomicInteger(0);
    private AtomicInteger plantCount = new AtomicInteger(0);
    private AtomicInteger deadPredators = new AtomicInteger(0);
    private AtomicInteger deadHerb = new AtomicInteger(0);*/

    public SpotStatistics(Spot spot) {
        this.spot = spot;
        this.spot.setSpotStatistics(this);
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    @Override
    public void run() {
        int predatorCount = 0, herbCount = 0, plantCount = 0, deadPredators = 0, deadHerb = 0;
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (Nature species : nature) {
            if (species instanceof Predator && !species.isDead()) {
                predatorCount++;
            } else if (species instanceof Herbivore && !species.isDead()) {
                herbCount++;
            } else if (species instanceof Plant) {
                plantCount++;
            } else if (species instanceof Predator && species.isDead()) {
                deadPredators++;
            } else if (species instanceof Herbivore && species.isDead()) {
                deadHerb++;
            }
        }

        if (turnOn) {
            System.out.println("Random " + spot + " *** Predators: " + predatorCount + " *** Herbivores: " + herbCount + " *** Plants: " + plantCount
                    + " *** Predators died: " + deadPredators + " *** Herbivores died: " + deadHerb);
        }
    }
}
