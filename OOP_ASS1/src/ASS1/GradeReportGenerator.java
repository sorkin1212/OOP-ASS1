//Names: Dan Ben Baruch & Tal Porta//
//IDs: 324179639 & 212999064//
package ASS1;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeReportGenerator {

    public static void main(String[] args) {
        try {
            // Open files for reading and writing
            Scanner scannerCS = new Scanner(new File("CS.txt"));
            Scanner scannerHedva = new Scanner(new File("hedva.txt"));
            PrintWriter writer = new PrintWriter(new File("report.txt"));

            // Read the first line from each file
            String lineCS = scannerCS.hasNextLine() ? scannerCS.nextLine() : null;
            String lineHedva = scannerHedva.hasNextLine() ? scannerHedva.nextLine() : null;

            // Process both files in parallel as long as both have lines
            while (lineCS != null && lineHedva != null) {
                // Split the CS student line by spaces (First name, Last name, ID)
                String[] partsCS = lineCS.split(" ");
                String firstName = partsCS[0];
                String lastName = partsCS[1];
                String idCS = partsCS[2];

                // Split the Hedva student line by spaces (ID, Grade 1, Grade 2)
                String[] partsHedva = lineHedva.split(" ");
                String idHedva = partsHedva[0];
                int grade1 = Integer.parseInt(partsHedva[1]);
                int grade2 = Integer.parseInt(partsHedva[2]);

                // Compare IDs since both files are sorted
                int comparison = idCS.compareTo(idHedva);

                if (comparison == 0) {
                    // Match found: Calculate average and write to report
                    int average = (grade1 + grade2) / 2;
                    writer.println(idCS + " " + firstName + " " + lastName + " " + average);

                    // Move to the next line in both files
                    lineCS = scannerCS.hasNextLine() ? scannerCS.nextLine() : null;
                    lineHedva = scannerHedva.hasNextLine() ? scannerHedva.nextLine() : null;
                } 
                else if (comparison < 0) {
                    // CS ID is smaller, advance only the CS file
                    lineCS = scannerCS.hasNextLine() ? scannerCS.nextLine() : null;
                } 
                else {
                    // Hedva ID is smaller, advance only the Hedva file
                    lineHedva = scannerHedva.hasNextLine() ? scannerHedva.nextLine() : null;
                }
            }

            // Close all files
            scannerCS.close();
            scannerHedva.close();
            writer.close();

            System.out.println("Report generated successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
