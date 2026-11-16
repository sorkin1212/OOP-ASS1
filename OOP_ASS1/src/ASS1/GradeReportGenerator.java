// Names: Dan Ben Baruch & Tal Portal
// IDs: 324179639 & 212999064
package ASS1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GradeReportGenerator {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Path departmentFile = Path.of(input.nextLine().trim());
            Path courseFile = Path.of(input.nextLine().trim());
            generateReport(departmentFile, courseFile);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void generateReport(Path departmentFile, Path courseFile)
            throws IOException {
        try (BufferedReader department = Files.newBufferedReader(departmentFile);
             BufferedReader course = Files.newBufferedReader(courseFile);
             BufferedWriter report = Files.newBufferedWriter(Path.of("report.txt"))) {

            String studentLine = department.readLine();
            String gradesLine = course.readLine();

            while (studentLine != null && gradesLine != null) {
                String[] student = studentLine.trim().split("\\s+");
                String[] grades = gradesLine.trim().split("\\s+");

                long studentId = Long.parseLong(student[2]);
                long courseId = Long.parseLong(grades[0]);
                int comparison = Long.compare(studentId, courseId);

                if (comparison == 0) {
                    int grade1 = Integer.parseInt(grades[1]);
                    int grade2 = Integer.parseInt(grades[2]);
                    int sum = grade1 + grade2;
                    String average = Integer.toString(sum / 2);

                    if (sum % 2 != 0) {
                        average += ".5";
                    }

                    report.write(student[2] + " " + student[0] + " "
                            + student[1] + " " + average);
                    report.newLine();
                }

                if (comparison <= 0) {
                    studentLine = department.readLine();
                }
                if (comparison >= 0) {
                    gradesLine = course.readLine();
                }
            }
        }
    }
}