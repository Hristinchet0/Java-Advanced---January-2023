import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        matrix = new int[rows][cols];


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (row * matrix[row].length) + col + 1;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int[] coordinates = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int targetRow = coordinates[0];
            int targetCol = coordinates[1];
            int radius = coordinates[2];

            int start = Math.max(0, targetRow - radius);
            int end = Math.min(matrix.length - 1, targetRow + radius);

            for (int i = start; i <= end; i++) {
                if ((isValidIndex(i, targetCol) && i != targetRow)) {
                    removeElement(i, targetCol);
                }
            }

            end = Math.max(0, targetCol - radius);
            for (int i = targetCol + radius; i >= end; i--) {
                if (isValidIndex(targetRow, i)) {
                    removeElement(targetRow, i);
                }
            }

            input = scanner.nextLine();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    private static void removeElement(int row, int col) {
        int rowSize = matrix[row].length - 1;

        if (rowSize > 0) {
            int elementToRemove = matrix[row][col];
            int index = 0;
            int[] array = new int[rowSize];

            for (int i = 0; i < matrix[row].length; i++) {
                int currentNum = matrix[row][i];

                if (currentNum != elementToRemove) {
                    array[index++] = currentNum;
                }
            }
            matrix[row] = array;
        } else {
            int[][] newMatrix = new int[matrix.length - 1][];

            boolean isFinish = false;

            int rowMatrix = 0;
            int newMatrixRow = 0;

            int elementToRemove = matrix[row][col];

            while (!isFinish) {
                int matrixRowSize = matrix[rowMatrix].length;

                if (matrixRowSize > 1 || matrix[rowMatrix][col] != elementToRemove) {
                    newMatrix[newMatrixRow] = matrix[rowMatrix];
                    newMatrixRow++;
                }

                rowMatrix++;

                if (rowMatrix >= matrix.length) {
                    isFinish = true;
                }
            }

            matrix = newMatrix;

        }
    }
}
