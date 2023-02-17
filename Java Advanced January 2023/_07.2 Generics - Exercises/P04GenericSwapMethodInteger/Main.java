package P04GenericSwapMethodInteger;

import P03GenericSwapMethodString.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        for (int i = 0; i < n; i++) {
            int text = Integer.parseInt(scanner.nextLine());
            box.add(text);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        box.swap(firstIndex, secondIndex);
        System.out.println(box);
    }
}
