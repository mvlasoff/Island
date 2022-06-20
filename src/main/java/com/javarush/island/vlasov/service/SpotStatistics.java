package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.*;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpotStatistics implements Runnable {
    private final Spot spot;
    //private boolean turnOn = false;

    private final HashMap<String, Integer> natureStatistics = new HashMap<>();

    private int predatorCount, herbCount, plantCount, deadPredators, deadHerb;

    public SpotStatistics(Spot spot) {
        this.spot = spot;
        this.spot.setSpotStatistics(this);
    }

    @Override
    public void run() {
        natureStatistics.clear();
        predatorCount = 0;
        herbCount = 0;
        plantCount = 0;
        deadPredators = 0;
        deadHerb = 0;
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (Nature species : nature) {
            if (!species.isDead()) {
                Integer i = natureStatistics.get(species.toString());
                if(i != null) {
                    i++;
                    natureStatistics.put(species.toString(), i);
                } else {
                    natureStatistics.put(species.toString(), 1);
                }
            }

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

/*        if (turnOn) {
            System.out.println("Random " + spot + " *** Predators: " + predatorCount + " *** Herbivores: " + herbCount + " *** Plants: " + plantCount
                    + " *** Predators died: " + deadPredators + " *** Herbivores died: " + deadHerb);
        }*/
    }

    /*public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }*/

    public HashMap<String, Integer> getNatureStatistics() {
        return natureStatistics;
    }

    public int getPredatorCount() {
        return predatorCount;
    }

    public int getHerbCount() {
        return herbCount;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public int getDeadPredators() {
        return deadPredators;
    }

    public int getDeadHerb() {
        return deadHerb;
    }
}
