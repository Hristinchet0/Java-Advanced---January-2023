import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> firstBoxQueue = new ArrayDeque<>();
        Stack<Integer> secondBoxStack = new Stack<>();

        String[] firstBox = scanner.nextLine().split(" ");
        String[] secondBox = scanner.nextLine().split(" ");

        for (String box : firstBox) {
            firstBoxQueue.offer(Integer.parseInt(box));
        }

        for (String box : secondBox) {
            secondBoxStack.push(Integer.parseInt(box));
        }

        int sumOfClaimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstNumber = firstBoxQueue.peek();
            int secondNumber = secondBoxStack.peek();

            int currentSum = firstNumber + secondNumber;

            if (currentSum % 2 == 0) {
                sumOfClaimedItems += currentSum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.offer(secondNumber);
                secondBoxStack.pop();
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (sumOfClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sumOfClaimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sumOfClaimedItems);
        }
    }
}
