package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.Constant;
import ru.javarush.vlasov.island.utility.RndGen;
import ru.javarush.vlasov.island.utility.Sleeper;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlantRunner implements Runnable {
    private final Plant plant;
    private final Spot spot;

    private final ScheduledExecutorService plantExecService;

    public PlantRunner(Plant plant, Spot spot, ScheduledExecutorService plantExecService) {
        this.plant = plant;
        this.spot = spot;
        this.plantExecService = plantExecService;
    }

    @Override
    public void run() {
        reproduce();
    }

    public void reproduce() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        int repIndex = reproductionIndex(nature);
        //Fewer plants, faster is their reproducing.
        if (repIndex < plant.getSpeciesPerSpot()
                && RndGen.getRndNum(plant.getSpeciesPerSpot() + 1) > repIndex) {
            Nature species = plant.getInstance();
            nature.add(species);
            plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) species, spot, plantExecService),
                    0, 1000, TimeUnit.MILLISECONDS);
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
