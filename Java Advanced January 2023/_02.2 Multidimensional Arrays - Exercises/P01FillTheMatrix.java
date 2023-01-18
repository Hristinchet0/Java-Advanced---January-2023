import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int count = 1;

        int[][] matrix = new int[n][n];

        patternA(n, count, matrix);

        patternB(n, count, matrix);

        if (pattern.equals("A")) {
            printMatrix(patternA(n, count, matrix));
        } else {
            printMatrix(patternB(n, count, matrix));
        }
    }

    private static int[][] patternB(int n, int count, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = n - 1; row >= 0  ; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
        return matrix;
    }

    private static int[][] patternA(int n, int count, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
