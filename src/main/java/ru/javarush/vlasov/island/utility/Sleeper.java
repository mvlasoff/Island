package ru.javarush.vlasov.island.utility;

public class Sleeper {
    private Sleeper() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}