import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = createMatrix(scanner);
        int[][] secondMatrix = createMatrix(scanner);

        if(areEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }
        else{
            System.out.println("not equal");
        }

    }

    private static int[][] createMatrix(Scanner scanner){

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentRow;
        }
        return matrix;
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix){
        if(firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length){
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if(firstMatrix[i][j] != secondMatrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}