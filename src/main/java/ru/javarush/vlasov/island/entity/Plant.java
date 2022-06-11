package ru.javarush.vlasov.island.entity;

public class Plant implements Nature {
    private final float WEIGHT = 1;
    private final int SPECIES_PER_SPOT = 200;
    private boolean isDead = false;

    public float getWeight() {
        return WEIGHT;
    }
    public int getSpeciesPerSpot() {
        return SPECIES_PER_SPOT;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public Nature getInstance() {
        return new Plant();
    }

}
