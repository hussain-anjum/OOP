import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the total marks of the exam: ");
                double totalMarks = scanner.nextDouble();
                
                System.out.print("Enter the marks obtained by the student: ");
                double obtainedMarks = scanner.nextDouble();
                
                if (totalMarks <= 0) {
                    System.out.println("Total marks must be greater than zero. Please try again.");
                    continue;
                }
                
                if (obtainedMarks < 0 || obtainedMarks > totalMarks) {
                    System.out.println("Obtained marks must be between 0 and the total marks. Please try again.");
                    continue;
                }

                double percentage = (obtainedMarks / totalMarks) * 100;
                String grade;
                
                if (percentage >= 80) {
                    grade = "A";
                } else if (percentage >= 70) {
                    grade = "B";
                } else if (percentage >= 60) {
                    grade = "C";
                } else if (percentage >= 50) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                System.out.printf("Percentage: %.2f%%\n", percentage);
                System.out.println("Grade: " + grade);

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // consume the invalid input
            }

            System.out.print("Do you want to enter another set of marks? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
