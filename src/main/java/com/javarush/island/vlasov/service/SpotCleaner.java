package com.javarush.island.vlasov.service;

import com.javarush.island.vlasov.entity.Nature;
import com.javarush.island.vlasov.entity.Animal;
import com.javarush.island.vlasov.entity.Spot;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpotCleaner implements Runnable {
    private final Spot spot;

    public SpotCleaner(Spot spot) {
        this.spot = spot;
    }


    @Override
    public void run() {
        CopyOnWriteArrayList<Nature> nature = spot.getNature();

        for (int i = 0; i < nature.size(); i++) {
            if (nature.get(i) != null && nature.get(i) instanceof Animal && nature.get(i).isDead()) {
                nature.remove(i);
                i--;
            }
        }

    }
}
