import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* 90/100*/
public class P02Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int startRow = -1;
        int startCol = -1;

        List<Integer> pillarsCoordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("S")) {
                    startRow = i;
                    startCol = j;
                } else if (matrix[i][j].equals("O")) {
                    pillarsCoordinates.add(i);
                    pillarsCoordinates.add(j);
                }
            }
        }

        int money = 0;

        while (money < 50) {
            String direction = scanner.nextLine();

            matrix[startRow][startCol] = "-";

            if (direction.equals("up")) {
                startRow--;
            } else if (direction.equals("down")) {
                startRow++;
            } else if (direction.equals("left")) {
                startCol--;
            } else if (direction.equals("right")) {
                startCol++;
            }

            if (isInside(n, startRow, startCol)) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            String newLocation = matrix[startRow][startCol];

            if (newLocation.equals("-")) {
                matrix[startRow][startCol] = "S";
            } else if (newLocation.equals("O")) {
                pillarsCoordinates.remove((Integer) startRow);
                pillarsCoordinates.remove((Integer) startCol);
                matrix[startRow][startCol] = "-";
                startRow = pillarsCoordinates.get(0);
                startCol = pillarsCoordinates.get(1);
                matrix[startRow][startCol] = "S";
            } else {
                money += Integer.parseInt(matrix[startRow][startCol]);
                matrix[startRow][startCol] = "S";
            }
        }

        if (money < 50) {
            System.out.printf("Money: %d%n", money);
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", money);
        }

        printMatrix(matrix);


    }

    private static boolean isInside(int n, int startRow, int startCol) {
        return startRow < 0 || startRow >= n || startCol < 0 || startCol >= n;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split("");
            matrix[i] = input;
        }
    }
}
