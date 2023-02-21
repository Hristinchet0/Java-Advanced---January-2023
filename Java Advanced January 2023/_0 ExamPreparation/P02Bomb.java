import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[n][n];

        int sapperRow = 0;
        int sapperCol = 0;

        int bombCounter = 0;
        int bombsFound = 0;

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                if (symbol == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (symbol == 'B') {
                    bombCounter++;
                }
                matrix[row][col] = symbol;
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            if (currentCommand.equals("up")) {
                if (sapperRow != 0) {
                    sapperRow--;
                }
            } else if (currentCommand.equals("down")) {
                if (sapperRow != n - 1) {
                    sapperRow++;
                }
            } else if (currentCommand.equals("left")) {
                if (sapperCol != 0) {
                    sapperCol--;
                }
            } else if (currentCommand.equals("right")) {
                if (sapperCol != n - 1) {
                    sapperCol++;
                }
            }

            if (matrix[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = '+';
                bombsFound++;
                if(bombsFound == bombCounter) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombCounter - bombsFound);
                return;
            }
        }

        if(bombCounter > bombsFound) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter - bombsFound, sapperRow, sapperCol);
        }


    }
}
