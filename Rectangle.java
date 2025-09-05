import java.util.Scanner;

class RectangleArea {
    private double length;
    private double width;
    
    public void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        length = scanner.nextDouble();
        System.out.print("Enter width of rectangle: ");
        width = scanner.nextDouble();
        scanner.close();
    }
    
    //area
    public double computeField() {
        return length * width;
    }

    public void fieldDisplay(double area) {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area of rectangle: " + area);
    }
}
public class Rectangle{
    public static void main(String[] args) {
        RectangleArea rectangle = new RectangleArea();
        rectangle.getData();
        double area = rectangle.computeField();
        rectangle.fieldDisplay(area);
    }
}
