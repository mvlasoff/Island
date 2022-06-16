package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.Animal;
import com.javarush.island.vlasov.entity.Nature;
import com.javarush.island.vlasov.entity.Plant;
import com.javarush.island.vlasov.entity.Spot;
import com.javarush.island.vlasov.utility.Constant;
import com.javarush.island.vlasov.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimalRunner implements Runnable {
    private final Animal animal;
    private Spot spot;

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
        makeHungry();
        move();
    }

    private void eat() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (Nature n : nature) {
            if (isSpeciesAvailable(n) && animal.getFoodLimit() > animal.getFull()) {
                tryToEat(n);
            }
        }
    }

    private void reproduce() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        if (canReproduce(animal, nature)) {
            for (Nature n : nature) {
                if (isSpeciesAvailable(n) && animal.getClass() == n.getClass()) {
                    Nature species = animal.getInstance();
                    nature.add(species);
                    animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) species, spot, animalExecService),
                            0, 1000, TimeUnit.MILLISECONDS);
                    break;
                }
            }
        }
    }

    private void dieIfHungry() {
        if ((animal.getFoodLimit() - animal.getFull()) >= (animal.getFoodLimit() / 2)) {
            animal.setDead();
        }
    }

    private void makeHungry() {
        animal.setFull(0.0F);
    }

    private void move() {
        if (!animal.isDead()) {

            float foodLimit = animal.getFoodLimit();
            int chanceToTravel = (int) (foodLimit + Constant.MAX_PERCENTAGE) / 2;
            int rndNum = RndGen.getRndNum(Constant.MAX_PERCENTAGE + 1);
            if(rndNum <= chanceToTravel) {
                tryTpMove();
            }
        }
    }

    private void tryTpMove() {
        int travelSpeed = animal.getTravelSpeed();
        Spot[][] spots = spot.getSpots();
        int actualTravelSpeed = RndGen.getRndNum(travelSpeed + 1);
        int x = spot.getID() / 10;
        int y = spot.getID() % 10;
        int checkX = x, checkY = y;
        for (int i = 1; i <= actualTravelSpeed; i++) {
            int nextX;
            do {
                nextX = RndGen.getRndNum(x - 1, x + 2);
            } while (nextX < 0 || nextX > spots.length - 1);
            x = nextX;

            int nextY;
            do {
                nextY = RndGen.getRndNum(y - 1, y + 2);
            } while (nextY < 0 || nextY > spots[0].length - 1);
            y = nextY;
        }

        if(checkX != x || checkY != y) {
            spot.getNature().remove(animal);
            spots[x][y].getNature().add(animal);
            spot = spots[x][y];
        }
    }

    private boolean isSpeciesAvailable(Nature nextSpecies) {
        return animal != nextSpecies && !animal.isDead() && !nextSpecies.isDead();
    }

    private void tryToEat(Nature n) {
        Integer chance = animal.getChanceToEat().get(n.getClass().getCanonicalName());
        if (chance != null && chance > 0) {
            int rndNum = RndGen.getRndNum(Constant.MAX_PERCENTAGE + 1);
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

    private boolean canReproduce(Animal animal, CopyOnWriteArrayList<Nature> nature) {
        int i = 0;
        for (Nature species : nature) {
            if (!animal.isDead() && !species.isDead() && species.getClass() == animal.getClass()) {
                i++;
            }
        }
        return i < animal.getSpeciesPerSpot();
    }
}
