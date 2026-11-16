//Names: Dan Ben Baruch & Tal Portal//
//IDs: 324179639 & 212999064//
package ASS1;
public class FinishingLine {
    private int placeCounter = 1;

    // Synchronized method to manage finish order safely across threads
    public synchronized void arrive(Horse h) {
        System.out.println("====> " + h.getHorseName() + " finished on " + placeCounter + "-th place");
        placeCounter++;
    }
}
