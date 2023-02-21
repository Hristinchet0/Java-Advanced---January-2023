import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeOfMatrix = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int cols = Integer.parseInt(sizeOfMatrix[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        int hunterRow = -1; //текущ ред -> въвеждаме невалидни коодинати защото не знаем къде е локацията
        int hunterCol = -1; //текуща колона

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("Y")) {
                    hunterRow = row;
                    hunterCol = col;
                    break;
                }
            }
        }

        List<String> movesList = new ArrayList<>();

        int countTreasure = 0;

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            //започваме движението
//            matrix[hunterRow][hunterCol] = "-";
            //премествам подводницата
            if (command.equals("up")) {
                if (isInside(hunterRow - 1, hunterCol, matrix) && !matrix[hunterRow - 1][hunterCol].equals("T")) {
                    hunterRow--;
                    movesList.add(command);
                }
            } else if (command.equals("down")) {
                if (isInside(hunterRow + 1, hunterCol, matrix) && !matrix[hunterRow + 1][hunterCol].equals("T")){
                    hunterRow++;
                    movesList.add(command);
                }
            } else if (command.equals("left")) {
                if (isInside(hunterRow, hunterCol - 1, matrix) && !matrix[hunterRow][hunterCol - 1].equals("T")) {
                    hunterCol--;
                    movesList.add(command);
                }
            } else if (command.equals("right")) {
                if (isInside(hunterRow, hunterCol + 1, matrix) && !matrix[hunterRow][hunterCol + 1].equals("T")) {
                    hunterCol++;
                    movesList.add(command);
                }
            }

            command = scanner.nextLine();
        }

        String hunterPosition = matrix[hunterRow][hunterCol];

        if (hunterPosition.equals("X")) {
            countTreasure++;
            System.out.println("I've found the treasure!");
            String path = String.join(", ", movesList);
            System.out.println("The right path is " + path);
        }

        if (countTreasure < 1) {
            System.out.println("The map is fake!");
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean isInside(int row, int col, String[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        } else return true;
    }
}