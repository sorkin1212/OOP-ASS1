// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

import java.util.concurrent.ThreadLocalRandom;

public class Horse implements Runnable {
    private final String name;
    private final FinishingLine finishingLine;
    private int distance;

    public Horse(String name, FinishingLine f, int distanse) {
        this.name = name;
        this.finishingLine = f;
        this.distance = distanse;
    }

    public String getHorseName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name + ": " + distance + " meters to finish");

        while (distance > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            int step = ThreadLocalRandom.current().nextInt(1, 21);
            distance = Math.max(0, distance - step);

            if (distance > 0) {
                System.out.println(name + ": " + distance + " meters to finish");
            }
        }

        finishingLine.arrive(this);
    }
}