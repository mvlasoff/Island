package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class IslandStatistics implements Runnable {
    final Spot[][] spots;

    public IslandStatistics(Spot[][] spots) {
        this.spots = spots;
    }


    @Override
    public void run() {
        int predatorCount = 0, herbCount = 0 , plantCount = 0, deadPredators = 0, deadHerb = 0;

        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                CopyOnWriteArrayList<Nature> nature = spots[i][j].getNature();
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
            }
        }

        System.out.println("Island statistics:" + " *** Predators: " + predatorCount + " *** Herbivores: " + herbCount + " *** Plants: " + plantCount
                + " *** Predators died: " + deadPredators + " *** Herbivores died: " + deadHerb);

    }
}
