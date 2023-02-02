import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //начин 1:
//        System.out.println(Collections.min(numbers));

        //начин 2:
        /*Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        printMinNumber.accept(numbers);*/

        //начин 3:
        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
        int minElement = getMinNumber.apply(numbers);
        System.out.println(minElement);



    }
}
