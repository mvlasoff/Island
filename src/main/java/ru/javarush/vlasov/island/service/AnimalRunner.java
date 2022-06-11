package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Spot;
import ru.javarush.vlasov.island.utility.RndGen;
import ru.javarush.vlasov.island.utility.Sleeper;

import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalRunner implements Runnable, Live {
    private final Animal animal;
    private final Spot spot;

    public AnimalRunner(Animal animal, Spot spot) {
        this.animal = animal;
        this.spot = spot;
    }

    @Override
    public void run() {
        eat();
        reproduce();
        move();
        Sleeper.sleep(10);
    }

    @Override
    public void eat() {
        //System.out.println(animal.toString() + " eat");
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (Nature n : nature) {
            if (animal != n && !animal.isDead() && !n.isDead() && animal.getFoodLimit() > animal.getFull()) {
                tryToEat(n);
            }
        }
    }

    private void tryToEat(Nature n) {
        Integer chance = animal.getChanceToEat().get(n.getClass().getCanonicalName());
        if (chance != null && chance > 0) {
            int rndNum = RndGen.getRndNum(100);
            if (chance >= rndNum) {
                n.setDead(true);
                animal.setFull(animal.getFull() + (int) n.getWeight());
                System.out.println(animal + " ate " + n);
            }
        }
    }

    @Override
    public void reproduce() {
        if (!animal.isDead()) {
            System.out.println(animal.toString() + " reproduce");
        }
    }

    @Override
    public void move() {
        if (!animal.isDead()) {
            System.out.println(animal.toString() + " move");
        }
    }
}
