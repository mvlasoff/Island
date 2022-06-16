package com.javarush.island.vlasov.entity;

public interface Nature {
    int getSpeciesPerSpot();

    void setDead();

    float getWeight();

    boolean isDead();

    Nature getInstance();
}
