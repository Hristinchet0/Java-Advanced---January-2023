import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countsOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;
        boolean isFinished = false;


        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                if (symbol == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
                matrix[row][col] = symbol;
            }
        }

        for (int i = 0; i < countsOfCommands; i++) {
            String commands = scanner.nextLine();

            matrix[playerRow][playerCol] = '-';
            switch (commands) {
                case "right":
                    playerCol++;
                    if (playerCol >= n) {
                        playerCol = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = matrix.length - 1;
                    }
                    break;
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= n) {
                        playerRow = 0;
                    }
                    break;
            }

            if (matrix[playerRow][playerCol] == 'F') {
                matrix[playerRow][playerCol] = 'f';
                isFinished = true;
                break;
            } else if (matrix[playerRow][playerCol] == 'B') {
                switch (commands) {
                    case "right":
                        playerCol++;
                        if (playerCol >= n) {
                            playerCol = 0;
                        }
                        break;
                    case "left":
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = matrix.length - 1;
                        }
                        break;
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = matrix.length - 1;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow >= n) {
                            playerRow = 0;
                        }
                        break;
                }
                if (matrix[playerRow][playerCol] == 'F') {
                    matrix[playerRow][playerCol] = 'f';
                    isFinished = true;
                    break;
                }
            }

            if (matrix[playerRow][playerCol] == 'T') {
                switch (commands) {
                    case "right":
                        playerCol--;
                        break;
                    case "left":
                        playerCol++;
                        break;
                    case "up":
                        playerRow++;
                        break;
                    case "down":
                        playerRow--;
                        break;
                }
            }

            matrix[playerRow][playerCol] = 'f';
        }

        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
