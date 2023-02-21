import java.util.List;
import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        List<String> commandsToMove = List.of(scanner.nextLine().split(","));

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        fillMatrix(matrix, scanner);

        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row < sizeOfMatrix; row++) {
            for (int col = 0; col < sizeOfMatrix; col++) {
                if (matrix[row][col].equals("D")) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        boolean isGoingInJail = false;
        int totalMoney = 0;

        for (int i = 0; i < commandsToMove.size(); i++) {
            String command = commandsToMove.get(i);

            matrix[startRow][startCol] = "+";

            if(command.equals("up")) {
                if(isInside(startRow - 1, startCol, matrix)) {
                    matrix[startRow][startCol] = "+";
                    startRow--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (command.equals("down")) {
                if(isInside(startRow + 1, startCol, matrix)) {
                    matrix[startRow][startCol] = "+";
                    startRow++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }

            } else if (command.equals("left")) {
                if(isInside(startRow , startCol - 1, matrix)) {
                    matrix[startRow][startCol] = "+";
                    startCol--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");;
                }

            } else if (command.equals("right")) {
                if(isInside(startRow, startCol + 1, matrix)) {
                    matrix[startRow][startCol] = "+";
                    startCol++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            }
            String currentPosition = matrix[startRow][startCol];
            if(currentPosition.equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                matrix[startRow][startCol] = "#";
                isGoingInJail = true;
                break;
            }

            if(currentPosition.equals("$")) {
                System.out.printf("You successfully stole %d$.%n", startRow * startCol);
                totalMoney += startRow * startCol;
            }

            matrix[startRow][startCol] = "D";
        }

        if(!isGoingInJail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        printMatrix(sizeOfMatrix, matrix);
    }

    private static void printMatrix(int sizeOfMatrix, String[][] matrix) {
        for (int i = 0; i < sizeOfMatrix; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }

    private static boolean isInside(int row, int col, String[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
    }


}
