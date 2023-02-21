import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int startRow = -1;
        int startCol = -1;

        List<Integer> mirrorsCoordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("A")) {
                    startRow = i;
                    startCol = j;
                } else if (matrix[i][j].equals("M")) {
                    mirrorsCoordinates.add(i);
                    mirrorsCoordinates.add(j);
                }
            }
        }

        int sales = 0;

        while (sales <= 65) {
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
                System.out.println("I do not need more swords!");
                break;
            }

            String newLocation = matrix[startRow][startCol];

            if (newLocation.equals("-")) {
                matrix[startRow][startCol] = "A";
            } else if (newLocation.equals("M")) {
                mirrorsCoordinates.remove((Integer) startRow);
                mirrorsCoordinates.remove((Integer) startCol);
                matrix[startRow][startCol] = "-";
                startRow = mirrorsCoordinates.get(0);
                startCol = mirrorsCoordinates.get(1);
                matrix[startRow][startCol] = "A";
            } else {
                sales += Integer.parseInt(matrix[startRow][startCol]);
                matrix[startRow][startCol] = "A";
            }
        }

        if (sales < 65) {
            System.out.printf("The king paid %d gold coins.%n", sales);
        } else {
            System.out.println("Very nice swords, I will come back for more!");
            System.out.printf("The king paid %d gold coins.%n", sales);
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
