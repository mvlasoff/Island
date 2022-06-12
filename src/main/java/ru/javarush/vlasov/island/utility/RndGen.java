package ru.javarush.vlasov.island.utility;

import java.util.concurrent.ThreadLocalRandom;

public class RndGen {
    private RndGen() {
    }

    public static int getRndNum(int num) {
        return ThreadLocalRandom.current().nextInt(num / 2, num);
    }
}
