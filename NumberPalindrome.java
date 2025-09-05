import java.util.Scanner;

public class NumberPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Enter a number (or type 'exit' to stop): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            try {
                int number = Integer.parseInt(input);
                int originalNumber = number;
                int reverse = 0;

                while (number != 0) {
                    int digit = number % 10;
                    reverse = reverse * 10 + digit;
                    number /= 10;
                }

                if (originalNumber == reverse) {
                    System.out.println("The entered number is a palindrome.");
                } else {
                    System.out.println("The entered number is not a palindrome.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        scanner.close();
    }
}