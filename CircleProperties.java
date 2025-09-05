import java.util.Scanner;

public class CircleProperties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        
        //circumference
        double circumference = 2 * Math.PI * radius;
        
        //area
        double area = Math.PI * radius * radius;
        
        System.out.println("Circumference of the circle: " + circumference);
        System.out.println("Area of the circle: " + area);
        
        scanner.close();
    }
}