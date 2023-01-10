import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String currentUrl = null;

        ArrayDeque<String> historyBrowser = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (historyBrowser.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = historyBrowser.pop();
                }
            } else {
                if (currentUrl != null) {
                    historyBrowser.push(currentUrl);
                }
                currentUrl = input;

            }

            System.out.println(currentUrl);

            input = scanner.nextLine();
        }
    }
}
