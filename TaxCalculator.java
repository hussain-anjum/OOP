import java.util.Scanner;
import java.util.InputMismatchException;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the net price of the item: ");
                double netPrice = scanner.nextDouble();

                if (netPrice <= 0) {
                    System.out.println("Net price must be greater than zero. Please try again.");
                    continue;
                }

                System.out.print("Enter the VAT rate (as a decimal, e.g., 0.23 for 23%): ");
                double vatRate = scanner.nextDouble();

                if (vatRate < 0) {
                    System.out.println("VAT rate must be non-negative. Please try again.");
                    continue;
                }

                System.out.print("Enter the quantity of items: ");
                int quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than zero. Please try again.");
                    continue;
                }

                // Gross value calculation
                double grossValue = netPrice * (1 + vatRate);

                // Total excluding VAT
                double totalExcludingVAT = grossValue * quantity;

                System.out.println("Gross value: " + grossValue);
                System.out.println("Total excluding VAT for " + quantity + " items: " + totalExcludingVAT);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            System.out.print("Do you want to calculate again? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
