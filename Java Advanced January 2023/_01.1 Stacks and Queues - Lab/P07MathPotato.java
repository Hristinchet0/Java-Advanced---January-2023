import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();
        Arrays.stream(input.split("\\s+")).forEach(queue::offer);

        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;

        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int count) {
        if (count <= 1)
            return false;

        for (int i = 2; i < count; i++)
            if (count % i == 0)
                return false;

        return true;
    }
}