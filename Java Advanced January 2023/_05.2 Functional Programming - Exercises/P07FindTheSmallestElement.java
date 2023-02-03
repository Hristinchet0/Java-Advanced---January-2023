import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

//        Consumer<List<Integer>> printLastIndexOfMinElement = list -> {
//            int minElement = Collections.min(numbers);
//            System.out.println(list.lastIndexOf(minElement));
//        };
//        printLastIndexOfMinElement.accept(numbers);

        Function<List<Integer>, Integer> getLastIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getLastIndexOfMinElement.apply(numbers));


    }
}
