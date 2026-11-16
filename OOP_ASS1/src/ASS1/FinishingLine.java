// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

public class FinishingLine {
    private int placeCounter = 1;

    public synchronized void arrive(Horse horse) {
        String name = horse.getHorseName();

        if (placeCounter == 1) {
            String border = "*******************************";
            System.out.println(border + "\n"
                    + "====> " + name + " finished first!\n"
                    + border);
        } else {
            System.out.println("====> " + name
                    + " finished on " + placeCounter + "-th place");
        }

        placeCounter++;
    }
}