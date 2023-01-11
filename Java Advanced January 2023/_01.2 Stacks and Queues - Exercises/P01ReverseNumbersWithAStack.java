import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String s : input) {
            stack.push(Integer.parseInt(s));
        }

//        for (Integer integer : stack) {
//            System.out.print(stack.pop() + " ");
//        }

        stack.forEach(e -> System.out.print(stack.pop() + " "));

    }
}
