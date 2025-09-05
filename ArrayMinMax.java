import java.util.Random;

public class ArrayMinMax {
    public static void main(String[] args) {
        Random random = new Random();
        
        // Generating an array of random numbers
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); 
        }
        int smallest = numbers[0];
        int largest = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }
        System.out.println("Array of random numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("Smallest number: " + smallest);
        System.out.println("Largest number: " + largest);
    }
}
