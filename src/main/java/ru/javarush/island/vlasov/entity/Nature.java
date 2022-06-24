package ru.javarush.island.vlasov.entity;

public interface Nature {
    float getWeight();

    int getSpeciesPerSpot();

    boolean isDead();

    void setDead();

    Nature getInstance();

    String toString();
}
