import java.util.*;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] roses = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] lilies = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Queue<Integer> rosesQueue = new ArrayDeque<>();
        Stack<Integer> liliesStack = new Stack<>();

        for (Integer number : roses) {
            rosesQueue.offer(number);
        }

        for (Integer number : lilies) {
            liliesStack.push(number);
        }

        int flowerWreaths = 0;
        int count = 0;
        int sum = 0;

        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {

            sum = rosesQueue.peek() + liliesStack.peek();

            if (sum == 15) {
                flowerWreaths++;
                rosesQueue.poll();
                liliesStack.pop();
            } else if (sum > 15) {
                int toDecrease = liliesStack.pop() - 2;
                liliesStack.push(toDecrease);
            } else {
                count += sum;
                rosesQueue.poll();
                liliesStack.pop();
            }
        }

        int additional = count / 15;
        flowerWreaths += additional;

        if (flowerWreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + flowerWreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - flowerWreaths) + " wreaths more!");
        }
    }
}
