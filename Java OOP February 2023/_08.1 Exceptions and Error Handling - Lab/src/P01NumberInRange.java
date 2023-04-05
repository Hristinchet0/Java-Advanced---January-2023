import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", start, end);

        int validNumber = readValidNumber(scanner, start, end);

        System.out.println("Valid number: " + validNumber);
    }

    private static int readValidNumber(Scanner scanner, int start, int end) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= start && number <= end) {
                    return number;
                }
            } catch (NumberFormatException e) {

            }
            System.out.println("Invalid number: " + input);

        }
    }
}
