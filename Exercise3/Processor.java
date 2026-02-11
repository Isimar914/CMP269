package Exercise3;
import java.io.*;
import java.util.*;

public class Processor {
    public static void main(String[] args) {

        try (
            Scanner scanner = new Scanner(new File("Exercise3/students.txt"));
            PrintWriter writer = new PrintWriter("Exercise3/grades_report.txt")
        ) {
            
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String name = "";
                
                try {
                    Scanner lineScanner =  new Scanner(line.trim());
                    
                    name = lineScanner.next();

                    //s1-3 means score1-3
                    int s1 = lineScanner.nextInt();
                    int s2 = lineScanner.nextInt();
                    int s3 = lineScanner.nextInt();

                    double average = (s1 + s2 + s3) / 3.0;

                    writer.println("Student: " + name + " | Average: " + String.format("%.2f", average));

                } catch (InputMismatchException e) {
                    System.out.println("Warning! Student Skipped: " + name);
                }

            }

        } catch (FileNotFoundException e) {
            //left empty
        }

        System.out.println("Processing Complete");

    }    
}
