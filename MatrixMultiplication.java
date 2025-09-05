import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Matrix A
        System.out.println("Enter the number of rows and columns for Matrix A:");
        int rowsA = scanner.nextInt();
        int columnsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][columnsA];
        System.out.println("Enter the elements of Matrix A:");
        inputMatrixElements(scanner, matrixA);

        //Matrix B
        System.out.println("Enter the number of rows and columns for Matrix B:");
        int rowsB = scanner.nextInt();
        int columnsB = scanner.nextInt();
        int[][] matrixB = new int[rowsB][columnsB];
        System.out.println("Enter the elements of Matrix B:");
        inputMatrixElements(scanner, matrixB);

        // Check if matrices can be multiplied
        if (columnsA != rowsB) {
            System.out.println("Matrices cannot be multiplied because the number of columns in Matrix A "
                    + "is not equal to the number of rows in Matrix B.");
        } else {
            //multiplication
            int[][] productMatrix = new int[rowsA][columnsB];
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < columnsB; j++) {
                    for (int k = 0; k < columnsA; k++) {
                        productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }

            //result
            System.out.println("Resultant Matrix after multiplication:");
            displayMatrix(productMatrix);
        }
        scanner.close();
    }
    //input matrix elements
    public static void inputMatrixElements(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    //display matrix
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
