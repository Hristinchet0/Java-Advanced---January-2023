import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addCommand = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyCommand = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractCommand = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printList = list -> list.forEach(number -> System.out.print(number + " "));

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add": //add 1
                    numbers = addCommand.apply(numbers);
                    break;
                case "multiply": //multiplies by 2
                    numbers = multiplyCommand.apply(numbers);
                    break;
                case "subtract": //subtracts 1
                    numbers = subtractCommand.apply(numbers);
                    break;
                case "print": //print all new numbers
                    printList.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
