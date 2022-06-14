package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.RndGen;
import ru.javarush.vlasov.island.utility.Sleeper;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimalRunner implements Runnable {
    private final Animal animal;
    private final Spot spot;

    private final ScheduledExecutorService animalExecService;

    public AnimalRunner(Animal animal, Spot spot) {
        this.animal = animal;
        this.spot = spot;
        this.animalExecService = Executors.newScheduledThreadPool(64);
    }

    @Override
    public void run() {
        eat();
        //Sleeper.sleep(100);
        reproduce();
        move();
    }

    public void eat() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (Nature n : nature) {
            if (animal != n
                    && !animal.isDead()
                    && !n.isDead()
                    && animal.getFoodLimit() > animal.getFull()) {
                tryToEat(n);
            }
        }
    }

    private void tryToEat(Nature n) {
        Integer chance = animal.getChanceToEat().get(n.getClass().getCanonicalName());
        if (chance != null && chance > 0) {
            int rndNum = RndGen.getRndNum(100);
            if (chance >= rndNum) {
                if (n instanceof Plant) {
                    animal.setFull(animal.getFull() + n.getWeight());
                } else {
                    n.setDead();
                    animal.setFull(animal.getFull() + n.getWeight());
                }
            }
        }
    }

    //TODO: add limit for reproducing.
    public void reproduce() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        ArrayList<Nature> newNature = new ArrayList<>();
        for (Nature n : nature) {
            if (animal != n
                    && !animal.isDead()
                    && !n.isDead()
                    && animal.getClass() == n.getClass()) {
                newNature.add(animal.getInstance());
            }
        }
        nature.addAll(newNature);
    }

    public void move() {
        if (!animal.isDead()) {
        }
    }
}
