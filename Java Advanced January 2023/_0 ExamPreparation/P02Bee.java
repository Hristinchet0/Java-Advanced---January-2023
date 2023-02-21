import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                String currentSymbol = matrix[row][col];
                if (currentSymbol.equals("B")) {
                    beeRow = row;
                    beeCol = col;
                    break;
                }
            }
        }

        int flowers = 0;

        String command = scanner.nextLine();

        while (true) {

            if (command.equals("End")) {
                break;
            }

            matrix[beeRow][beeCol] = ".";

            if (command.equals("up")) {
                beeRow--;
            } else if (command.equals("down")) {
                beeRow++;
            } else if (command.equals("left")) {
                beeCol--;
            } else if (command.equals("right")) {
                beeCol++;
            }

            if (beeCol < 0 || beeCol >= n || beeRow < 0 || beeRow >= n) {
                System.out.println("The bee got lost!");
                break;
            }

            if (command.equals("End")) {
                break;
            }

            if (matrix[beeRow][beeCol].equals("f")) {
                flowers++;
            } else if (matrix[beeRow][beeCol].equals("O")) {
                matrix[beeRow][beeCol] = ".";
                if (command.equals("up")) {
                    beeRow--;
                } else if (command.equals("down")) {
                    beeRow++;
                } else if (command.equals("left")) {
                    beeCol--;
                } else if (command.equals("right")) {
                    beeCol++;
                }

                if (matrix[beeRow][beeCol].equals("f")) {
                    flowers++;
                }
            }

            matrix[beeRow][beeCol] = "B";

            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        printMatrix(matrix);


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "*--*-"
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isInside(int row, int col, String[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
