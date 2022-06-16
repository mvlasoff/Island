package com.javarush.island.vlasov.entity;

import java.util.concurrent.atomic.AtomicBoolean;

public class Plant implements Nature {
    private final float WEIGHT = 1;
    private final int SPECIES_PER_SPOT = 200;
    private AtomicBoolean isDead = new AtomicBoolean(false);

    public float getWeight() {
        return WEIGHT;
    }
    public int getSpeciesPerSpot() {
        return SPECIES_PER_SPOT;
    }

    public boolean isDead() {
        return isDead.get();
    }

    public void setDead() {
        isDead.set(true);
    }

    @Override
    public Nature getInstance() {
        return new Plant();
    }

}
