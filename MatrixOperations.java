import java.util.Scanner;

public class MatrixOperations {
    private int[][] matrixA;
    private int[][] matrixB;
    private int rows;
    private int columns;

    public void inputMatrixElements() {
        Scanner scanner = new Scanner(System.in);

        // Matrix A
        System.out.println("Enter rows and columns:");
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        matrixA = new int[rows][columns];
        System.out.println("Elements of Matrix A:");
        fillMatrix(scanner, matrixA);

        // Matrix B
        matrixB = new int[rows][columns];
        System.out.println("Elements of Matrix B:");
        fillMatrix(scanner, matrixB);
    }

    private void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element of [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public int[][] addMatrices() {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public int[][] subtractMatrices() {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    public void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixOperations matrixOps = new MatrixOperations();
        matrixOps.inputMatrixElements();

        int[][] sumMatrix = matrixOps.addMatrices();
        System.out.println("Addition:");
        matrixOps.displayMatrix(sumMatrix);

        int[][] diffMatrix = matrixOps.subtractMatrices();
        System.out.println("Subtraction:");
        matrixOps.displayMatrix(diffMatrix);
    }
}

