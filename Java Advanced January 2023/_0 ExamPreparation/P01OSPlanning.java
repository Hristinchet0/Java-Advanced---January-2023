import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> taskStack = new Stack<>();
        Queue<Integer> threadsQueue = new ArrayDeque<>();

        String[] tasks = scanner.nextLine().split(", ");
        String[] threads = scanner.nextLine().split(" ");

        for (String task : tasks) {
            taskStack.push(Integer.parseInt(task));
        }

        for (String thread : threads) {
            threadsQueue.offer(Integer.parseInt(thread));
        }

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        int thread = threadsQueue.peek();
        int task = taskStack.peek();

        while (task != taskToBeKilled) {

            if(thread >= task) {
                taskStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

            thread = threadsQueue.peek();
            task = taskStack.peek();

        }

        System.out.printf("Thread with value %d killed task %d%n", thread, taskToBeKilled);
        for (Integer n : threadsQueue) {
            System.out.print(n + " ");
        }
    }
}
