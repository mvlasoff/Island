package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.*;
import com.javarush.island.vlasov.utility.Constant;
import com.javarush.island.vlasov.utility.RndGen;

import java.util.HashMap;
import java.util.Set;

public class IslandStatistics implements Runnable {
    final Spot[][] spots;

    private final HashMap<String, Integer> islandNatureStatistics = new HashMap<>();

    final private Spot randomSpot;

    public IslandStatistics(Spot[][] spots) {
        this.spots = spots;
        randomSpot = spots[RndGen.getRndNum(spots.length)][RndGen.getRndNum(spots[0].length)];
    }

    @Override
    public void run() {
        islandNatureStatistics.clear();
        String islandMinSpecies, islandMaxSpecies;
        int islandMin, islandMax;
        int predatorCount = 0, herbCount = 0, plantCount = 0, deadPredators = 0, deadHerb = 0;

        for (Spot[] spot : spots) {
            for (Spot sp : spot) {
                SpotStatistics spotStatistics = sp.getSpotStatistics();
                predatorCount += spotStatistics.getPredatorCount();
                herbCount += spotStatistics.getHerbCount();
                plantCount += spotStatistics.getPlantCount();
                deadPredators += spotStatistics.getDeadPredators();
                deadHerb += spotStatistics.getDeadHerb();

                fillIslandNatureStatistics(spotStatistics);
            }
        }

        HashMap<String, Integer> randSpotNatureStatistics = randomSpot.getSpotStatistics().getNatureStatistics();
        String minSpecies = getMinPopulation(randSpotNatureStatistics), maxSpecies = getMaxPopulation(randSpotNatureStatistics);
        int min = randSpotNatureStatistics.get(minSpecies), max = randSpotNatureStatistics.get(maxSpecies);

        islandMinSpecies = getMinPopulation(islandNatureStatistics);
        islandMaxSpecies = getMaxPopulation(islandNatureStatistics);
        islandMin = islandNatureStatistics.get(islandMinSpecies);
        islandMax = islandNatureStatistics.get(islandMaxSpecies);

        System.out.println("Random " + randomSpot
                + "\t *** Predators: " + randomSpot.getSpotStatistics().getPredatorCount()
                + "\t\t *** Herbivores: " + randomSpot.getSpotStatistics().getHerbCount()
                + "\t *** Plants: " + randomSpot.getSpotStatistics().getPlantCount()
                + "\t *** Max population: " + Constant.unicodeSymbols.get(maxSpecies)
                + " - " + max
                + "\t *** Min population: " + Constant.unicodeSymbols.get(minSpecies)
                + " - " + min
                + " *** Predators died: " + randomSpot.getSpotStatistics().getDeadPredators()
                + " *** Herbivores died: " + randomSpot.getSpotStatistics().getDeadHerb());

        System.out.println("Island statistics:"
                + "\t *** Predators: " + predatorCount
                + "\t *** Herbivores: " + herbCount
                + "\t *** Plants: " + plantCount
                + "\t *** Max population: " + Constant.unicodeSymbols.get(islandMaxSpecies)
                + " - " + islandMax
                + " *** Min population: " + Constant.unicodeSymbols.get(islandMinSpecies)
                + " - " + islandMin
                + " *** Predators died: " + deadPredators
                + " *** Herbivores died: " + deadHerb);

        System.out.println("*********************************************************************");
    }

    private void fillIslandNatureStatistics(SpotStatistics spotStatistics) {
        HashMap<String, Integer> natureStatistics = spotStatistics.getNatureStatistics();
        Set<String> nature = natureStatistics.keySet();
        for (String str : nature) {
            Integer i = natureStatistics.get(str);
            Integer count = islandNatureStatistics.get(str);
            if (count != null) {
                count = count + i;
                islandNatureStatistics.put(str, count);
            } else {
                islandNatureStatistics.put(str, 1);
            }
        }
    }

    private String getMinPopulation(HashMap<String, Integer> natureStatistics) {
        String minSpecies = "";
        int min = Integer.MAX_VALUE;
        Set<String> strSet = natureStatistics.keySet();
        for (String str : strSet) {
            Integer i = natureStatistics.get(str);
            if (i < min) {
                min = i;
                minSpecies = str;
            }
        }
        return minSpecies;
    }

    private String getMaxPopulation(HashMap<String, Integer> natureStatistics) {
        String maxSpecies = "";
        int max = 0;
        Set<String> strSet = natureStatistics.keySet();
        for (String str : strSet) {
            Integer i = natureStatistics.get(str);
            if (i > max && !"Plant".equals(str)) {
                max = i;
                maxSpecies = str;
            }
        }
        return maxSpecies;
    }
}
