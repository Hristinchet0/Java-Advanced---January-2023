import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //размер на бойното поле -> размер на квадратна матрица

        String[][] matrix = new String[n][n]; //бойното поле

        //1. да си напълним матрицата
        fillMatrix(matrix, scanner);

        //2. да намерим къде се намира подводницата (S) на бойното поле -> от къде стартираме
        int submarineRow = -1; //текущ ред -> въвеждаме невалидни коодинати защото не знаем къде е подводницата
        int submarineCol = -1; //текуща колона

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        int countDamage = 0; //макс 3
        int countCruiser = 0; //макс 3

        while (true) {

            //започваме движението
            matrix[submarineRow][submarineCol] = "-";
            //премествам подводницата
            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }

            //имаме новата позиция на подводницата -> matrix[submarineRow][submarineCol]
            String submarinePosition = matrix[submarineRow][submarineCol];
            if (submarinePosition.equals("-")) {
                matrix[submarineRow][submarineCol] = "S";
            } else if (submarinePosition.equals("*")) {
                //имаме мина
                matrix[submarineRow][submarineCol] = "S";
                countDamage++;


                if (countDamage == 3) {
                    //ако мината ни удари 3 пъти играта свършва -> подводницата е унищожена
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }
            } else if (submarinePosition.equals("C")) {
                //ако подводницата достигне C кораб, тя го разрушава
                matrix[submarineRow][submarineCol] = "S";
                countCruiser++;

                if (countCruiser == 3) {
                    //ако кораб C бъде разрушен 3 пъти играта приключва и подводницата печели
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }

            command = scanner.nextLine();
        }

        //отпечатваме матрицата след като битката е приключила
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "*--*-"
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
