import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            ArrayList<Double> numbers = new ArrayList<>();
            
            System.out.println("Enter numbers to calculate their average. Enter any non-numeric value to stop.");

            while (true) {
                System.out.print("Enter a number: ");
                if (scanner.hasNextDouble()) {
                    double number = scanner.nextDouble();
                    numbers.add(number);
                } else {
                    scanner.next(); // consume the non-numeric input
                    break;
                }
            }

            if (numbers.size() == 0) {
                System.out.println("No numbers entered.");
            } else {
                // Calculate the average
                double sum = 0;
                for (double num : numbers) {
                    sum += num;
                }
                double average = sum / numbers.size();
                System.out.println("Average of the entered numbers: " + average);
            }

            System.out.print("Do you want to calculate another average? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
