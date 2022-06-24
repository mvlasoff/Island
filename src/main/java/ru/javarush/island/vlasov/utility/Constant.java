package ru.javarush.island.vlasov.utility;

import java.util.HashMap;

public final class Constant {

    public static final int MAX_PERCENTAGE = 100;
    public static final HashMap<String, String> unicodeSymbols = new HashMap<>();

    static {
        unicodeSymbols.put("Bear", "\uD83D\uDC3B");
        unicodeSymbols.put("Boa", "\uD83D\uDC0D");
        unicodeSymbols.put("Boar", "\uD83D\uDC17");
        unicodeSymbols.put("Buffalo", "\uD83D\uDC03");
        unicodeSymbols.put("Caterpillar", "\uD83D\uDC1B");
        unicodeSymbols.put("Deer", "\uD83E\uDD8C");
        unicodeSymbols.put("Duck", "\uD83E\uDD86");
        unicodeSymbols.put("Eagle", "\uD83E\uDD85");
        unicodeSymbols.put("Fox", "\uD83E\uDD8A");
        unicodeSymbols.put("Goat", "\uD83D\uDC10");
        unicodeSymbols.put("Horse", "\uD83D\uDC0E");
        unicodeSymbols.put("Mouse", "\uD83D\uDC01");
        unicodeSymbols.put("Rabbit", "\uD83D\uDC07");
        unicodeSymbols.put("Sheep", "\uD83D\uDC11");
        unicodeSymbols.put("Wolf", "\uD83D\uDC3A");
    }

    private Constant() {
    }
}
