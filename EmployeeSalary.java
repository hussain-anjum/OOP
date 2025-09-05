import java.util.Scanner;

class Employee {
    private double salary;
    private int hoursOfWork;

    public void getInfo(double salary, int hoursOfWork) {
        this.salary = salary;
        this.hoursOfWork = hoursOfWork;
    }

    public void addSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    public void addWork() {
        if (hoursOfWork > 6) {
            salary += 5;
        }
    }

    public void printFinalSalary() {
        System.out.println("Final salary: $" + salary);
    }
}

public class EmployeeSalary{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter number of hours of work per day: ");
        int hoursOfWork = scanner.nextInt();
        
        scanner.close();

        Employee emp = new Employee();
        emp.getInfo(salary, hoursOfWork);
        emp.addSal();
        emp.addWork();
        emp.printFinalSalary();
    }
}
