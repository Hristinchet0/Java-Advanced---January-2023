import java.util.ArrayDeque;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> digits = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            if(Character.isDigit(input[i].charAt(0))) {
                digits.push(Integer.parseInt(input[i]));
            } else if (input[i].charAt(0) == '+') {
                Integer firstNumber = digits.pop();
                Integer secondNumber = Integer.parseInt(input[i + 1]);

                Integer result = firstNumber + secondNumber;
                digits.push(result);
                i++;
            } else if (input[i].charAt(0) == '-') {
                Integer firstNumber = digits.pop();
                Integer secondNumber = Integer.parseInt(input[i + 1]);

                Integer result = firstNumber - secondNumber;
                digits.push(result);
                i++;
            }
        }

        System.out.println(digits.peek());
        
        


    }
}
