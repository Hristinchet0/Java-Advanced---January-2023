import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[n][n];

        int pythonRow = 0;
        int pythonCol = 0;

        int foodCounter = 0;
        int foodFound = 0;
        int pythonLength = 1;

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                if (symbol == 's') {
                    pythonRow = row;
                    pythonCol = col;
                } else if (symbol == 'f') {
                    foodCounter++;
                }
                matrix[row][col] = symbol;
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            switch (currentCommand){
                case "right":
                    pythonCol++;
                    if (pythonCol >= n){
                        pythonCol = 0;
                    }
                    break;
                case "left":
                    pythonCol--;
                    if (pythonCol < 0){
                        pythonCol = matrix.length - 1;
                    }
                    break;
                case "up":
                    pythonRow--;
                    if (pythonRow < 0){
                        pythonRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    pythonRow++;
                    if (pythonRow >= n){
                        pythonRow = 0;
                    }
                    break;
            }

            if (matrix[pythonRow][pythonCol] == 'f') {
                matrix[pythonRow][pythonCol] = '+';
                pythonLength++;
                foodFound++;
                if(foodFound == foodCounter) {
                    System.out.printf("You win! Final python length is %d", pythonLength);
                    return;
                }
            } else if (matrix[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }

        if (foodCounter > foodFound) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCounter - foodFound);
        }
    }
}
