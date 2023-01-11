import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (isValid(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isValid(String input) {

        ArrayDeque<Character> charStack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            if(c == '(') {
                charStack.push(')');
            } else if (c == '{') {
                charStack.push('}');
            } else if (c == '[') {
                charStack.push(']');
            } else if (charStack.isEmpty() || charStack.pop() != c) {
                return false;
            }
        }
        return charStack.isEmpty();
    }
}
