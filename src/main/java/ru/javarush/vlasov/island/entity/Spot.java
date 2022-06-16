package ru.javarush.vlasov.island.entity;

import ru.javarush.vlasov.island.service.SpotStatistics;
import ru.javarush.vlasov.island.utility.RndGen;

import java.util.concurrent.CopyOnWriteArrayList;

public class Spot {

    private int iD;
    private final CopyOnWriteArrayList<Nature> nature = new CopyOnWriteArrayList<>();
    private SpotStatistics spotStatistics;

    public Spot(int iD) {
        this.iD = iD;
    }

    public void setSpotStatistics(SpotStatistics spotStatistics){
        this.spotStatistics = spotStatistics;
    }

    public CopyOnWriteArrayList<Nature> getNature() {
        return nature;
    }

    public SpotStatistics getSpotStatistics() {
        return spotStatistics;
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
        for (int i = 1; i <= RndGen.getRndNum(n.getSpeciesPerSpot() + 1); i++) {
            nature.add(n.getInstance());
        }
    }

    @Override
    public String toString() {
        return "Spot[" + iD / 10  + "]" + "[" + iD % 10 + "]";
    }
}
