import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        //да намерим къде е мишката
        int mouseRow = -1; //текущ ред -> въвеждаме невалидни коодинати защото не знаем къде е мишката
        int mouseCol = -1; //текуща колона

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                String currentSymbol = matrix[row][col];
                if (currentSymbol.equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        int countCheese = 0;

        while (!command.equals("end")) {

            //започваме движението
            matrix[mouseRow][mouseCol] = "-";

            //преместваме мишката
            if (command.equals("up")) {
                mouseRow--;
            } else if (command.equals("down")) {
                mouseRow++;
            } else if (command.equals("left")) {
                mouseCol--;
            } else if (command.equals("right")) {
                mouseCol++;
            }

            //преди да поставим мишката на новото и място -> проверка на ред и колоната
            if (mouseCol < 0 || mouseCol >= n || mouseRow < 0 || mouseRow >= n) {
                System.out.println("Where is the mouse?");
                break;
            }

            //имаме новата позиция на мишката
            String currentPositionMouse = matrix[mouseRow][mouseCol];

            if(currentPositionMouse.equals("c")) {
                countCheese++;
            } else if (currentPositionMouse.equals("B")) {
                //бонус една позиция
                continue;
            }

            matrix[mouseRow][mouseCol] = "M";

            command = scanner.nextLine();
        }

        //проверка дали е изяла достатъчно сиренца
        if (countCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countCheese);
        }

        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "M--"
            matrix[row] = scanner.nextLine().split("");
        }
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
