import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }

        int searchNumber = Integer.parseInt(scanner.nextLine());
        //boolean isFoundAtLeastOnce = false;
        StringBuilder output = new StringBuilder();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNumber = matrix[r][c];
                if (currentNumber == searchNumber) {
//                    System.out.println(r + " " + c);
//                    isFoundAtLeastOnce = true;
                    output.append(r)
                            .append(" ")
                            .append(c)
                            .append(System.lineSeparator());
                }
            }
        }

//        if (!isFoundAtLeastOnce) {
//            System.out.println("not found");
//        }

        System.out.println(output.isEmpty() ? "not found" : output);

    }
}
