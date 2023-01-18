import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeMatrix = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizeMatrix[0]);
        int cols = Integer.parseInt(sizeMatrix[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[row] = input;
        }

        String commands = scanner.nextLine();

        while (!commands.equals("END")) {
            String[] command = commands.split("\\s+");
            String cmd = command[0];

            if (cmd.equals("swap") && command.length == 5) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                if ((row1 >= 0 && row1 < rows) && (row2 >= 0 && row2 < rows) &&
                        (col1 >= 0 && col1 < cols) && (col2 >= 0 && col2 < cols)) {
                    String first = matrix[row1][col1];
                    String second = matrix[row2][col2];
                    matrix[row1][col1] = second;
                    matrix[row2][col2] = first;

                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            commands = scanner.nextLine();
        }
    }
}
