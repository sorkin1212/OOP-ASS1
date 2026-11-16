//Names: Dan Ben Baruch & Tal Porta//
//IDs: 324179639 & 212999064//
package ASS1;
import java.util.Random;

public class Horse implements Runnable {
    private String name;
    private FinishingLine finishingLine;
    private int distance;

    // Constructor to initialize horse properties
    public Horse(String name, FinishingLine finishingLine, int distance) {
        this.name = name;
        this.finishingLine = finishingLine;
        this.distance = distance;
    }

    // Getter for the horse name
    public String getHorseName() {
        return name;
    }

    @Override
    public void run() {
        Random rand = new Random();

        // Run until the distance reaches 0
        while (distance > 0) {
            try {
                // Sleep for 1 second in each step
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
                return;
            }

            // Reduce distance by a random value between 1 and 20
            int step = rand.nextInt(20) + 1;
            distance -= step;
            if (distance < 0) {
                distance = 0;
            }

            // Print the remaining distance
            System.out.println(name + ": " + distance + " meters to finish");

            // Check if the horse reached the finish line
            if (distance == 0) {
                finishingLine.arrive(this);
                break;
            }
        }
    }
}
