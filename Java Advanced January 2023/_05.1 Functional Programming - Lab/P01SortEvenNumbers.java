import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());

        numbers.removeIf(num -> num % 2 != 0);

        printNumbers(numbers);
        System.out.println();

        List<Integer> sortedNumbers = numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());

        printNumbers(sortedNumbers);


    }

    private static void printNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if(i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
