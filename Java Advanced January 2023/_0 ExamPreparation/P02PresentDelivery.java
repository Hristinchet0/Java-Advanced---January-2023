import java.util.Scanner;

public class P02PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentToGift = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int startRow = -1;
        int startCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        int happyKids = 0;

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning")) {

            matrix[startRow][startCol] = "-";

            switch (command) {
                case "up":
                    startRow--;
                    break;
                case "down":
                    startRow++;
                    break;
                case "left":
                    startCol--;
                    break;
                case "right":
                    startCol++;
                    break;
            }

            if (startRow >= 0 && startCol >= 0 && startRow < n && startCol < n) {
                if (matrix[startRow][startCol].equals("-")) {
                    matrix[startRow][startCol] = "-";
                    matrix[startRow][startCol] = "S";
                } else if (matrix[startRow][startCol].equals("V")) {
                    matrix[startRow][startCol] = "-";
                    matrix[startRow][startCol] = "S";
                    presentToGift--;
                    happyKids++;
                    if (presentToGift == 0) {
                        break;
                    }
                } else if (matrix[startRow][startCol].equals("X")) {
                    matrix[startRow][startCol] = "-";
                    matrix[startRow][startCol] = "S";
                } else if (matrix[startRow][startCol].equals("C")) {
                    matrix[startRow][startCol] = "-";
                    matrix[startRow][startCol] = "S";
                    for (int i = -1; i <= 1; i++) {
                        if (matrix[startRow + i][startCol].equals("V") || matrix[startRow + i][startCol].equals("X")) {
                            matrix[startRow + i][startCol] = "-";
                            presentToGift--;
                            happyKids++;
                            if (presentToGift == 0) {
                                break;
                            }
                        }
                        if (matrix[startRow][startCol + i].equals("V") || matrix[startRow][startCol + 1].equals("X")) {
                            matrix[startRow][startCol + i] = "-";
                            presentToGift--;
                            happyKids++;
                            if (presentToGift == 0) {
                                break;
                            }
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }

        if (presentToGift == 0) {
            System.out.println("Santa ran out of presents!");
        }

        int niceKidsLeft = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j].equals("V")) {
                    niceKidsLeft++;
                }
            }
            System.out.println();
        }

        if (niceKidsLeft != 0) {
            System.out.println("No presents for " + niceKidsLeft + " nice kid/s.");
        } else {
            System.out.println("Good job, Santa! " + happyKids + " happy nice kid/s.");
        }
}

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }

}
