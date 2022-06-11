package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.utility.Sleeper;

public class PlantRunner implements Runnable, Grow {
    private final Plant plant;

    public PlantRunner(Plant plant) {
        this.plant = plant;
    }

    @Override
    public void run() {
        reproduce();
        Sleeper.sleep(10);
    }

    @Override
    public void reproduce() {
        System.out.println(plant.getClass().getCanonicalName() + " reproduce");
    }
}
