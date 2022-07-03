package ru.javarush.island.vlasov.service;

import ru.javarush.island.vlasov.entity.Spot;
import ru.javarush.island.vlasov.utility.Constant;
import ru.javarush.island.vlasov.utility.RndGen;

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
        int[] statistics = {predatorCount, herbCount, plantCount, deadPredators, deadHerb};

        fillStatisticsVariables(statistics);

        HashMap<String, Integer> randSpotNatureStatistics = randomSpot.getSpotStatistics().getNatureStatistics();
        String minSpecies = getMinPopulation(randSpotNatureStatistics), maxSpecies = getMaxPopulation(randSpotNatureStatistics);
        int min = randSpotNatureStatistics.get(minSpecies), max = randSpotNatureStatistics.get(maxSpecies);

        printRandomSpot(minSpecies, maxSpecies, min, max);

        islandMinSpecies = getMinPopulation(islandNatureStatistics);
        islandMaxSpecies = getMaxPopulation(islandNatureStatistics);
        islandMin = islandNatureStatistics.get(islandMinSpecies);
        islandMax = islandNatureStatistics.get(islandMaxSpecies);

        printIsland(islandMinSpecies, islandMaxSpecies, islandMin, islandMax, statistics);
        System.out.println("*********************************************************************");
    }

    private void printIsland(String islandMinSpecies, String islandMaxSpecies, int islandMin, int islandMax, int[] statistics) {
        System.out.println("Island statistics:"
                + "\t *** Predators: " + statistics[0]
                + "\t *** Herbivores: " + statistics[1]
                + "\t *** Plants: " + statistics[2]
                + "\t *** Max population: " + Constant.unicodeSymbols.get(islandMaxSpecies)
                + " - " + islandMax
                + " *** Min population: " + Constant.unicodeSymbols.get(islandMinSpecies)
                + " - " + islandMin
                + " *** Predators died: " + statistics[3]
                + " *** Herbivores died: " + statistics[4]);
    }

    private void printRandomSpot(String minSpecies, String maxSpecies, int min, int max) {
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
    }

    private void fillStatisticsVariables(int[] statistics) {
        for (Spot[] spot : spots) {
            for (Spot sp : spot) {
                SpotStatistics spotStatistics = sp.getSpotStatistics();
                statistics[0] += spotStatistics.getPredatorCount();
                statistics[1] += spotStatistics.getHerbCount();
                statistics[2] += spotStatistics.getPlantCount();
                statistics[3] += spotStatistics.getDeadPredators();
                statistics[4] += spotStatistics.getDeadHerb();

                fillIslandNatureStatistics(spotStatistics);
            }
        }
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
