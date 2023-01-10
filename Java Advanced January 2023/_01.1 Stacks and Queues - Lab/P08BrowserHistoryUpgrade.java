import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            if (!input.equals("back") && !input.equals("forward")) {
                browserHistoryStack.push(input);

                if (!forwardQueue.isEmpty()) {
                    forwardQueue.clear();
                }
                System.out.println(input);
            } else if (input.equals("back")) {
                if (browserHistoryStack.size() > 1) {
                    forwardQueue.push(browserHistoryStack.peek());
                    browserHistoryStack.pop();
                    System.out.println(browserHistoryStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (!forwardQueue.isEmpty()) {
                    browserHistoryStack.push(forwardQueue.peek());
                    System.out.println(forwardQueue.pop());
                } else {
                    System.out.println("no next URLs");
                }
            }

            input = scanner.nextLine();
        }
    }
}
