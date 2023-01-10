import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Arrays.stream(input.split("\\s+")).forEach(queue::offer);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.peek());

    }
}
