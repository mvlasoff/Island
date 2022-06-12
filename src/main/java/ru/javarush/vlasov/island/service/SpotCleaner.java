package ru.javarush.vlasov.island.service;

import ru.javarush.vlasov.island.entity.Nature;
import ru.javarush.vlasov.island.entity.Spot;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpotCleaner implements Runnable {
    private final Spot spot;

    public SpotCleaner(Spot spot) {
        this.spot = spot;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (int i = 0; i < nature.size(); i++) {
            if (nature.get(i) != null && nature.get(i).isDead()) {
                nature.remove(i);
            }
        }

    }
}
