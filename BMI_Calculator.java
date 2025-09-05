import java.util.Scanner;
import java.util.InputMismatchException;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.print("Enter your weight in pounds: ");
                float weight = scanner.nextFloat();

                if (weight <= 0) {
                    System.out.println("Weight must be greater than zero. Please try again.");
                    continue;
                }

                System.out.print("Enter your height in inches: ");
                float height = scanner.nextFloat();

                if (height <= 0) {
                    System.out.println("Height must be greater than zero. Please try again.");
                    continue;
                }

                // BMI calculation
                float bmi = (weight / (height * height)) * 703;

                System.out.println("Your BMI: " + bmi);

                if (bmi <= 16.00) {
                    System.out.println("Starvation");
                } else if (bmi <= 16.99) {
                    System.out.println("Emaciation");
                } else if (bmi <= 18.49) {
                    System.out.println("Underweight");
                } else if (bmi <= 22.99) {
                    System.out.println("Normal, low range");
                } else if (bmi <= 24.99) {
                    System.out.println("Normal, high range");
                } else if (bmi <= 27.49) {
                    System.out.println("Overweight, low range");
                } else if (bmi <= 29.99) {
                    System.out.println("Overweight, high range");
                } else if (bmi <= 34.99) {
                    System.out.println("1st degree obesity");
                } else if (bmi <= 39.99) {
                    System.out.println("2nd degree obesity");
                } else {
                    System.out.println("3rd degree obesity");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            System.out.print("Do you want to calculate another BMI? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}