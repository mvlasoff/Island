package ru.javarush.vlasov.island.entity;

public interface Nature {
    int getSpeciesPerSpot();

    void setDead(boolean dead);

    float getWeight();

    boolean isDead();

    Nature getInstance();
}
