package ru.javarush.island.vlasov.utility;

import java.util.concurrent.ThreadLocalRandom;

public final class RndGen {
    private RndGen() {
    }

    public static int getRndNum(int num) {
        return ThreadLocalRandom.current().nextInt(num);
    }

    public static int getRndNum(int from, int num) {
        return ThreadLocalRandom.current().nextInt(from, num);
    }
}
