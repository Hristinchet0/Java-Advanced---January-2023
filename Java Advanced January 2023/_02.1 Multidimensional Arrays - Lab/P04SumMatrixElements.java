import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = currentRow;
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sumMatrixNumbers = 0;

        for (int[] arr : matrix) {
            for (int number : arr) {
                sumMatrixNumbers += number;
            }
        }

        System.out.println(sumMatrixNumbers);
    }
}
