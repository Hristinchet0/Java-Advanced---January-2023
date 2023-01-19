import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String[] input = scanner.nextLine().split("\\s+");
//
//        List<Integer> numbers = new ArrayList<>();
//
//        for (String element : input) {
//            numbers.add(Integer.parseInt(element));
//        }

//        List<Integer> sorted = numbers
//                .stream()
//                .sorted((l, r) -> r.compareTo(l))
//                .collect(Collectors.toList());
//
//        int limit = Math.min(sorted.size(), 3);
//        for (int i = 0; i < limit; i++) {
//            System.out.print(sorted.get(i) + " ");
//        }

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .collect(Collectors.toList());

        for (Integer num : nums) {
            System.out.print(num + " ");
        }

    }
}
