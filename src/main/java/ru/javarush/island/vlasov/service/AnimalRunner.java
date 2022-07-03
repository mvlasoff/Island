package ru.javarush.island.vlasov.service;

import ru.javarush.island.vlasov.entity.Animal;
import ru.javarush.island.vlasov.entity.Nature;
import ru.javarush.island.vlasov.entity.Plant;
import ru.javarush.island.vlasov.entity.Spot;
import ru.javarush.island.vlasov.utility.Constant;
import ru.javarush.island.vlasov.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("FieldCanBeLocal")
public class AnimalRunner implements Runnable {
    private final Animal animal;
    private final int PERIOD = 1000;
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
        if (!animal.isDead()) {
            CopyOnWriteArrayList<Nature> nature = spot.getNature();

            for (Nature nat : nature) {
                if (isSpeciesAvailable(nat) && this.animal.getFoodLimit() > this.animal.getFull()) {
                    tryToEat(nat);
                }
            }
        }
    }

    private void reproduce() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();
        if (!animal.isDead() && canReproduce(nature)) {
            for (Nature nat : nature) {
                if (isSpeciesAvailable(nat) && this.animal.getClass() == nat.getClass()) {
                    Nature species = this.animal.getInstance();
                    nature.add(species);
                    animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) species, spot, animalExecService),
                            0, PERIOD, TimeUnit.MILLISECONDS);
                    break;
                }
            }
        }
    }

    private void dieIfHungry() {
        if (!animal.isDead() && animal.getFull() < (animal.getFoodLimit() / 2)) {
            animal.setDead();
        }
    }

    private void makeHungry() {
        if (!animal.isDead()) {
            animal.setFull(0.0F);
        }
    }

    private void move() {
        if (!animal.isDead()) {
            float foodLimit = animal.getFoodLimit();
            int chanceToTravel = (int) (foodLimit + Constant.MAX_PERCENTAGE) / 2;
            int rndNum = RndGen.getRndNum(Constant.MAX_PERCENTAGE + 1);
            if (rndNum <= chanceToTravel) {
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
        int xY = getNextCoordinates(x, y, actualTravelSpeed);
        int newX = xY / 10;
        int newY = xY % 10;

        if (newX != x || newY != y) {
            spot.getNature().remove(animal);
            spots[newX][newY].getNature().add(animal);
            spot = spots[newX][newY];
        }
    }

    private void tryToEat(Nature n) {
        Integer chance = animal.getChanceToEat().get(n.getClass().getCanonicalName());
        if (chance != null) {
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

    private boolean canReproduce(CopyOnWriteArrayList<Nature> nature) {
        int i = 0;
        for (Nature species : nature) {
            if (!animal.isDead() && !species.isDead() && species.getClass() == animal.getClass()) {
                i++;
            }
        }
        return i < animal.getSpeciesPerSpot();
    }

    private boolean isSpeciesAvailable(Nature nextSpecies) {
        return animal != nextSpecies && !nextSpecies.isDead();
    }

    private int getNextCoordinates(int x, int y, int actualTravelSpeed) {
        Spot[][] spots = spot.getSpots();
        for (int i = 1; i <= actualTravelSpeed; i++) {
            int nextX;
            do {
                nextX = RndGen.getRndNum(x - 1, (x + 1) + 1);
            } while (nextX < 0 || nextX > spots.length - 1);
            x = nextX;

            int nextY;
            do {
                nextY = RndGen.getRndNum(y - 1, (y + 1) + 1);
            } while (nextY < 0 || nextY > spots[0].length - 1);
            y = nextY;
        }
        return x * 10 + y;
    }
}
