// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

import java.util.Scanner;

public class HorseRace {

    public static void main(String[] args) {
        int distance;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter distance: ");
            distance = input.nextInt();
        }

        String[] horseNames = {
            "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten"
        };

        FinishingLine finishingLine = new FinishingLine();
        Thread[] threads = new Thread[horseNames.length];

        for (int i = 0; i < horseNames.length; i++) {
            Horse horse = new Horse(horseNames[i], finishingLine, distance);
            threads[i] = new Thread(horse);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}