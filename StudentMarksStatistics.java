import java.util.Scanner;

public class StudentMarksStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting assignment name
        System.out.print("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();

        // Input and verifing 30 student marks
        double[] marks = new double[30];
        for (int i = 0; i < 30; i++) {
            while (true) {
                System.out.print("Enter mark for student " + (i + 1) + " (0-30): ");
                try {
                    double mark = Double.parseDouble(scanner.nextLine());
                    if (mark >= 0 && mark <= 30) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Error: Mark should be between 0 and 30. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a numerical value.");
                }
            }
        }

        // assignment name and marks
        System.out.println("\nAssignment: " + assignmentName);
        System.out.print("Marks: ");
        for (double mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();

        // Calculate highest and lowest marks using Algorithm 1
        double highest = marks[0];
        double lowest = marks[0];
        for (double mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
            if (mark < lowest) {
                lowest = mark;
            }
        }
        System.out.println("Highest Mark: " + highest);
        System.out.println("Lowest Mark: " + lowest);

        //Calculate mean and standard deviation using Algorithm 2
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        double mean = sum / marks.length;

        double varianceSum = 0;
        for (double mark : marks) {
            varianceSum += Math.pow(mark - mean, 2);
        }
        double variance = varianceSum / marks.length;
        double standardDeviation = Math.sqrt(variance);

        System.out.printf("Mean: %.2f%n", mean);
        System.out.printf("Standard Deviation: %.2f%n", standardDeviation);

        scanner.close();
    }
}
