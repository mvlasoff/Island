package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.utility.RndGen;
import com.javarush.island.vlasov.entity.Nature;
import com.javarush.island.vlasov.entity.Plant;
import com.javarush.island.vlasov.entity.Spot;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlantRunner implements Runnable {
    private final Plant plant;
    private final Spot spot;
    private final int PERIOD = 1;

    private final ScheduledExecutorService plantExecService;

    public PlantRunner(Plant plant, Spot spot, ScheduledExecutorService plantExecService) {
        this.plant = plant;
        this.spot = spot;
        this.plantExecService = plantExecService;
    }

    @Override
    public void run() {
        grow();
        reproduce();
    }

    private void grow() {
        plant.setAlive();
    }

    public void reproduce() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        int repIndex = reproductionIndex(nature);
        //When more plants, then slower their reproduction.
        if (!plant.isDead()
                && repIndex < plant.getSpeciesPerSpot()
                && RndGen.getRndNum(plant.getSpeciesPerSpot() + 1) > repIndex) {
            Nature species = plant.getInstance();
            nature.add(species);
            plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) species, spot, plantExecService),
                    0, PERIOD, TimeUnit.SECONDS);
        }
    }

    private int reproductionIndex(CopyOnWriteArrayList<Nature> nature) {
        int i = 0;
        for (Nature species : nature) {
            if (species instanceof Plant) {
                i++;
            }
        }
        return i;
    }
}
