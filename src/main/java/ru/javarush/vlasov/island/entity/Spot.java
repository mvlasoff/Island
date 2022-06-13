package ru.javarush.vlasov.island.entity;

import ru.javarush.vlasov.island.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;

public class Spot {
    private final CopyOnWriteArrayList<Nature> nature = new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayList<Nature> getNature() {
        return nature;
    }

    public void makeNature() {
        createSpecies(new Bear());
        createSpecies(new Boa());
        createSpecies(new Boar());
        createSpecies(new Buffalo());
        createSpecies(new Caterpillar());
        createSpecies(new Deer());
        createSpecies(new Duck());
        createSpecies(new Eagle());
        createSpecies(new Fox());
        createSpecies(new Goat());
        createSpecies(new Horse());
        createSpecies(new Mouse());
        createSpecies(new Plant());
        createSpecies(new Rabbit());
        createSpecies(new Sheep());
        createSpecies(new Wolf());
    }

    private void createSpecies(Nature n) {
        nature.add(n);
        for (int i = 1; i <= RndGen.getRndNum(n.getSpeciesPerSpot() / 2, n.getSpeciesPerSpot() + 1); i++) {
            nature.add(n.getInstance());
        }
    }
}
