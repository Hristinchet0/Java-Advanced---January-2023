import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        int km = 0;

        String[][] trace = new String[n][n];
        fillMatrix(trace, scanner);

        int currentRow = 0;
        int currentCol = 0;

        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunels(trace, tunnelsCoordinates);

        String directions = scanner.nextLine();

        while (!directions.equals("End")) {
            switch (directions) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }

            String movedPlace = trace[currentRow][currentCol];

            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("T")) {
                currentRow = tunnelsCoordinates.get(2);
                currentCol = tunnelsCoordinates.get(3);
                km += 30;

                trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";

            } else if (movedPlace.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            }

            directions = scanner.nextLine();
        }

        if (directions.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }

        System.out.printf("Distance covered %d km.%n", km);

        trace[currentRow][currentCol] = "C";

        printMatrix(trace);


    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void findTunels(String[][] trace, List<Integer> tunnelsCoordinates) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                String currentElement = trace[row][col];
                if (currentElement.equals("T")) {
                    tunnelsCoordinates.add(row);
                    tunnelsCoordinates.add(col);
                }

            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
