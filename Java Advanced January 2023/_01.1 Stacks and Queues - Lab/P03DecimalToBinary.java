import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        if(decimalNumber == 0) {
            System.out.println(0);
        } else {
            while (decimalNumber !=0) {
                stack.push(decimalNumber % 2);
                decimalNumber /= 2;
            }
        }

        stack.forEach(System.out::print);
    }
}
