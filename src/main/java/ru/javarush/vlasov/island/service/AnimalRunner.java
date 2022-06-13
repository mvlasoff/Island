package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.RndGen;
import ru.javarush.vlasov.island.utility.Sleeper;

import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalRunner implements Runnable {
    private final Animal animal;
    private final Spot spot;

    public AnimalRunner(Animal animal, Spot spot) {
        this.animal = animal;
        this.spot = spot;
    }

    @Override
    public void run() {
        do {
            Sleeper.sleep(100);
            eat();
            Sleeper.sleep(100);
            reproduce();
            Sleeper.sleep(100);
            move();
            Sleeper.sleep(100);
        } while (!Thread.currentThread().isInterrupted());
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

    public void reproduce() {
        if (!animal.isDead()) {
        }
    }

    public void move() {
        if (!animal.isDead()) {
        }
    }
}
