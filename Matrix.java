import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] elements;

    // Constructor
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new int[rows][columns];
    }

    // Getter method for rows
    public int getRows() {
        return rows;
    }

    // Getter method for columns
    public int getColumns() {
        return columns;
    }

    // Set the element
    public void setElement(int i, int j, int value) {
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            elements[i][j] = value;
        } else {
            System.out.println("Invalid position");
        }
    }

    // Add matrices
    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
            System.out.println("Matrices cannot be added");
            return null;
        }

        Matrix result = new Matrix(matrix1.rows, matrix1.columns);
        for (int i = 0; i < matrix1.rows; i++) {
            for (int j = 0; j < matrix1.columns; j++) {
                result.elements[i][j] = matrix1.elements[i][j] + matrix2.elements[i][j];
            }
        }
        return result;
    }

    // Multiply matrices
    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.columns != matrix2.rows) {
            System.out.println("Matrices cannot be multiplied");
            return null;
        }

        Matrix result = new Matrix(matrix1.rows, matrix2.columns);
        for (int i = 0; i < matrix1.rows; i++) {
            for (int j = 0; j < matrix2.columns; j++) {
                for (int k = 0; k < matrix1.columns; k++) {
                    result.elements[i][j] += matrix1.elements[i][k] * matrix2.elements[k][j];
                }
            }
        }
        return result;
    }

    // Display matrix
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get matrix dimensions from user
        System.out.print("Enter the number of rows for the matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int columns = scanner.nextInt();

        // Create and populate first matrix
        System.out.println("Enter elements for the first matrix:");
        Matrix matrix1 = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                int value = scanner.nextInt();
                matrix1.setElement(i, j, value);
            }
        }

        // Create and populate second matrix
        System.out.println("Enter elements for the second matrix:");
        Matrix matrix2 = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                int value = scanner.nextInt();
                matrix2.setElement(i, j, value);
            }
        }

        // Display matrices
        System.out.println("\nMatrix 1:");
        matrix1.display();

        System.out.println("\nMatrix 2:");
        matrix2.display();

        // Adding matrices
        System.out.println("\nMatrix Addition:");
        Matrix sum = Matrix.add(matrix1, matrix2);
        if (sum != null) {
            sum.display();
        }

        // Multiplying matrices
        System.out.println("\nMatrix Multiplication:");
        Matrix product = Matrix.multiply(matrix1, matrix2);
        if (product != null) {
            product.display();
        }

        scanner.close();
    }
}
