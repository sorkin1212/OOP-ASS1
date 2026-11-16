//Names: Dan Ben Baruch & Tal Porta//
//IDs: 324179639 & 212999064//
package ASS1;
import java.util.Scanner;

public class HorseRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter the race distance
        System.out.print("Enter distance  : ");
        int totalDistance = scanner.nextInt();

        FinishingLine finishLine = new FinishingLine();

        // Array of 10 horse names
        String[] horseNames = {
            "One", "Two", "Three", "Four", "Five", 
            "Six", "Seven", "Eight", "Nine", "Ten"
        };

        Thread[] threads = new Thread[10];

        // Create and start a thread for each horse
        for (int i = 0; i < 10; i++) {
            Horse horse = new Horse(horseNames[i], finishLine, totalDistance);
            threads[i] = new Thread(horse);
            threads[i].start();
        }

        // Wait for all threads to finish their execution
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Race finished!");
    }
}
