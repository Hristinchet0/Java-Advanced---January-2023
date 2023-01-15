import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = readMatrix(r, c, scanner);
        char[][] matrix2 = readMatrix(r, c, scanner);

        printResultMatrix(matrix1, matrix2);

    }

    private static void printResultMatrix(char[][] matrix1, char[][] matrix2) {
        for (char[] arr : intersectionOfTwoMatrices(matrix1, matrix2)) {
            for (char n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static char[][] intersectionOfTwoMatrices(char[][] matrix1, char[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        char[][] resultMatrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char element;
                if (matrix1[r][c] == matrix2[r][c]) {
                    element = matrix1[r][c];
                } else {
                    element = '*';
                }
                resultMatrix[r][c] = element;
            }
        }
        return resultMatrix;
    }

    public static char[][] readMatrix(int r, int c, Scanner scanner) {
        char[][] matrix = new char[r][c];

        for (int row = 0; row < r; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < input.length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
        return matrix;
    }
}
