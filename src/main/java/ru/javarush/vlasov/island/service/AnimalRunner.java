package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Plant;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.Constant;
import ru.javarush.vlasov.island.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimalRunner implements Runnable {
    private final Animal animal;
    private final Spot spot;

    private final ScheduledExecutorService animalExecService;

    public AnimalRunner(Animal animal, Spot spot, ScheduledExecutorService animalExecService) {
        this.animal = animal;
        this.spot = spot;
        this.animalExecService = animalExecService;
    }

    @Override
    public void run() {
        eat();
        reproduce();
        dieIfHungry();
        move();
    }

    private void dieIfHungry() {
        if (!animal.isDead()) {
        }
    }

    public void eat() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (Nature n : nature) {
            if (hasNextAnimal(n) && animal.getFoodLimit() > animal.getFull()) {
                tryToEat(n);
            }
        }
    }

    private boolean hasNextAnimal(Nature nextSpecies) {
        return animal != nextSpecies && !animal.isDead() && !nextSpecies.isDead();
    }

    private void tryToEat(Nature n) {
        Integer chance = animal.getChanceToEat().get(n.getClass().getCanonicalName());
        if (chance != null && chance > 0) {
            int rndNum = RndGen.getRndNum(Constant.MAX_PERCENTAGE + 1);
            if (chance >= rndNum) {
                if (n instanceof Plant) {
                    n.setDead();
                    animal.setFull(animal.getFull() + n.getWeight());
                } else {
                    n.setDead();
                    animal.setFull(animal.getFull() + n.getWeight());
                }
            }
        }
    }

    public void reproduce() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        if (canReproduce(animal, nature)) {
            for (Nature n : nature) {
                if (hasNextAnimal(n) && animal.getClass() == n.getClass()) {
                    Nature species = animal.getInstance();
                    nature.add(species);
                    animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) species, spot, animalExecService),
                            0, 1000, TimeUnit.MILLISECONDS);
                    break;
                }
            }
        }
    }

    private boolean canReproduce(Animal animal, CopyOnWriteArrayList<Nature> nature) {
        int i = 0;
        for (Nature species : nature) {
            if(species.getClass() == animal.getClass()) {
                i++;
            }
        }
        if(i >= animal.getSpeciesPerSpot()) {
            return false;
        } else {
            return true;
        }
    }

    public void move() {
        if (!animal.isDead()) {
        }
    }
}
