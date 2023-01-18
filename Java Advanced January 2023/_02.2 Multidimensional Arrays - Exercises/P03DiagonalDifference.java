import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[sizeMatrix][sizeMatrix];

        for (int row = 0; row < sizeMatrix; row++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int col = 0; col < sizeMatrix; col++) {
                matrix[row][col] = Integer.parseInt(rowInput[col]);
            }
        }
        int primaryDiagonalSum = 0;

//        for (int row = 0; row < sizeMatrix; row++) {
//            for (int col = 0; col < sizeMatrix; col++) {
//                if(row == col) {
//                    primaryDiagonalSum += matrix[row][col];
//                }
//            }
//        }

        for (int index = 0; index < sizeMatrix; index++) {
            primaryDiagonalSum += matrix[index][index];
        }

        int secondaryDiagonal = 0;

        for (int row = 0; row < sizeMatrix; row++) {
            secondaryDiagonal = secondaryDiagonal + matrix[row][sizeMatrix - row - 1];
        }

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonal));

    }
}
