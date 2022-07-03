package ru.javarush.island.vlasov.entity;

import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("FieldCanBeLocal")
public class Plant implements Nature {

    private final float WEIGHT = 1;
    private final int SPECIES_PER_SPOT = 200;
    private final AtomicBoolean isDead = new AtomicBoolean(false);

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

    @SuppressWarnings({"Can be used for certain plant configuration.", "unused"})
    public void setAlive() {
        isDead.set(false);
    }

    @Override
    public Nature getInstance() {
        return new Plant();
    }

    @Override
    public String toString() {
        return "Plant";
    }
}
