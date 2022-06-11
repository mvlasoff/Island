package ru.javarush.vlasov.island.entity;

import ru.javarush.vlasov.island.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;

public class Spot {
    private final CopyOnWriteArrayList<Nature> nature = new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayList<Nature> getNature() {
        return nature;
    }

    public void makeNature() {
        for (int i = 1; i <= RndGen.getRndNum(Bear.SPECIES_PER_SPOT + 1); i++) {
            nature.add(new Bear());
        }
    }
}
