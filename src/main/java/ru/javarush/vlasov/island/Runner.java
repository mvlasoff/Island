package ru.javarush.vlasov.island;

import ru.javarush.vlasov.island.entity.Boa;
import ru.javarush.vlasov.island.entity.Island;
import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Rabbit;
import ru.javarush.vlasov.island.service.IslandRunner;
import ru.javarush.vlasov.island.service.SpotRunner;

public class Runner {
    public static void main(String[] args) {
        //new SpotRunner().runSpot();
        new IslandRunner().runIsland();
    }
}
