import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int numbersOfElementsOffer = Integer.parseInt(tokens[0]);
        int numbersOfElementsPoll = Integer.parseInt(tokens[1]);
        int numberCheck = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numbersQueue::offer);

        for (int i = 0; i < numbersOfElementsPoll; i++) {
            numbersQueue.poll();
        }

        if(numbersQueue.contains(numberCheck)) {
            System.out.println("true");
        } else if (numbersQueue.size() == 0) {
            System.out.println(0);
        } else {
            int minNumberInQueue = Integer.MAX_VALUE;
            while (!numbersQueue.isEmpty()) {
                int num = numbersQueue.poll();
                if(minNumberInQueue > num) {
                    minNumberInQueue = num;
                }
            }
            System.out.println(minNumberInQueue);
        }
    }
}
