package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Animal;
import ru.javarush.vlasov.island.utility.Sleeper;

public class AnimalRunner implements Runnable, Live {
    private final Animal animal;

    public AnimalRunner(Animal animal) {
        this.animal = animal;
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
        System.out.println(animal.getClass().getCanonicalName() + "eat");
    }

    @Override
    public void reproduce() {
        System.out.println(animal.getClass().getCanonicalName() + "reproduce");
    }

    @Override
    public void move() {
        System.out.println(animal.getClass().getCanonicalName() + "move");
    }
}
