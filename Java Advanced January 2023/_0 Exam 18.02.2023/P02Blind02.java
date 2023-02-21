import java.util.Scanner;

public class P02Blind02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeOfMatrix = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int cols = Integer.parseInt(sizeOfMatrix[1]);

        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, scanner);

        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        int row = -1;
        int col = -1;

        String command = scanner.nextLine();

        int touchedPlayers = 0;
        int playerMoves = 0;

        while (!command.equals("Finish")) {

            if (touchedPlayers == 3) {
                break;
            }

            row = startRow;
            col = startCol;

            switch (command) {
                case "right":
                    col++;
                    break;
                case "left":
                    col--;
                    break;
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
            }

            if (isInMatrix(matrix, row, col) && !(matrix[row][col] == 'O')) {
                playerMoves++;
                startRow = row;
                startCol = col;

                if (matrix[row][col] == 'P') {
                    touchedPlayers++;
                    matrix[row][col] = '-';
                }
            }

            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedPlayers, playerMoves);

    }


    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                matrix[row][i] = input[i].charAt(0);
            }
        }
    }

    private static boolean isInMatrix(char[][] matrix, int row, int column) {
        return (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length);
    }
}
