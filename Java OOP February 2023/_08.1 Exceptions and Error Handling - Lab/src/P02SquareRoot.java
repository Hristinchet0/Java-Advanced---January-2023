
import java.util.Scanner;

public class P02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            double result = Math.sqrt(number);
            if (result >= 0) {
                System.out.printf("%.2f%n", Math.sqrt(number));
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}
