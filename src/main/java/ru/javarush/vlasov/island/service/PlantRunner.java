package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.Sleeper;

public class PlantRunner implements Runnable {
    private final Plant plant;
    private final Spot spot;

    public PlantRunner(Plant plant, Spot spot) {
        this.plant = plant;
        this.spot = spot;
    }

    @Override
    public void run() {
        do {
            reproduce();
            Sleeper.sleep(10);
        } while (!Thread.currentThread().isInterrupted());
    }

    public void reproduce() {
        //System.out.println(plant.getClass().getCanonicalName() + " reproduce");
    }
}
