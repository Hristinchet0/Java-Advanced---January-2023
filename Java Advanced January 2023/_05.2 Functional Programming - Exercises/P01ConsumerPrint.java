import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Function<приема, връща> -> apply
//        Consumer<приема> -> void -> accept
//        Supplier<връща> -> get
//        Predicate<приема> -> връща true / false -> test
//        BiFunction<приема1, приема2, връща> -> apply

        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

//        //пример 1:
//        Consumer<String> print = n -> System.out.println(n);
//
//        for (String name : names) {
//            print.accept(name);
//        }

        //Пример 2:
        Consumer<String[]> printArray =
                array -> {
                    for (String name : array) {
                        System.out.println(name);
                    }
                };

        printArray.accept(names);



    }
}
