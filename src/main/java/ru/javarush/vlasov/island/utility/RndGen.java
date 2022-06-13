package ru.javarush.vlasov.island.utility;

import java.util.concurrent.ThreadLocalRandom;

public class RndGen {
    private RndGen() {
    }

    public static int getRndNum(int num) {
        return ThreadLocalRandom.current().nextInt(num);
    }

    public static int getRndNum(int from, int num) {
        return ThreadLocalRandom.current().nextInt(from, num);
    }
}
