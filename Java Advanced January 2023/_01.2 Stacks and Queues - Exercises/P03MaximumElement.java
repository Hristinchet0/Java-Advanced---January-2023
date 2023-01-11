import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * •	The first line of input contains an integer N, where 1 ≤ N ≤ 105.
 * •	The next N lines contain commands. All commands will be valid and in the format described.
 * •	The element X will be in the range 1 ≤ X ≤ 109.
 * •	The type of the command will be in the range 1 ≤ Type ≤ 3.
 * <p>
 * •	"1 X" - Push the element X into the stack.
 * •	"2" - Delete the element present at the top of the stack.
 * •	"3" - Print the maximum element in the stack.
 * •	For each command of type "3", print the maximum element in the stack on a new line.
 */

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String input = scanner.nextLine();
            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command) {
                case "1":
                    int numberPush = Integer.parseInt(commands[1]);
                    numbers.push(numberPush);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    //Found the maximum number
                    System.out.println(Collections.max(numbers));
                    break;
            }

        }
    }
}
