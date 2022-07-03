package ru.javarush.island.vlasov.service;

import ru.javarush.island.vlasov.entity.Nature;
import ru.javarush.island.vlasov.entity.Plant;
import ru.javarush.island.vlasov.entity.Spot;
import ru.javarush.island.vlasov.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("FieldCanBeLocal")
public class PlantRunner implements Runnable {
    private final Plant plant;
    private final Spot spot;
    private final int PERIOD = 1000;

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
        //When more plants, then slower their reproduction.
        if (repIndex < plant.getSpeciesPerSpot()
                && RndGen.getRndNum(plant.getSpeciesPerSpot() + 1) > repIndex) {
            Nature species = plant.getInstance();
            nature.add(species);
            plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) species, spot, plantExecService),
                    0, PERIOD, TimeUnit.MILLISECONDS);
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
