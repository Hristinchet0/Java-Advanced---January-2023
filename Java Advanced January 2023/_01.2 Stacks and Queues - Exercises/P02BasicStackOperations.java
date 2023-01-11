import java.util.*;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //•	On the first line, you will be given N, S, and X separated by a single space.
        //•	On the next line, you will be given a line of numbers separated by one or more white spaces.

        String[] tokens = scanner.nextLine().split("\\s+");
        int numbersOfElementsPush = Integer.parseInt(tokens[0]);
        int numbersOfElementsPop = Integer.parseInt(tokens[1]);
        int numberCheck = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .limit(numbersOfElementsPush)
                .forEach(numbersStack::push);

        for (int i = 0; i < numbersOfElementsPop; i++) {
            numbersStack.pop();
        }

        //•	On a single line print, either "true" if X is present in the stack, otherwise, print the smallest element in the stack.
        //•	If the stack is empty – print 0.

        if (numbersStack.contains(numberCheck)) {
            System.out.println("true");
        } else {
            if (numbersStack.size() == 0) {
                System.out.println(0);
            } else {
//                int minNumberInStack = Integer.MAX_VALUE;
//                while (!numbersStack.isEmpty()) {
//                    int num = numbersStack.pop();
//                    if (minNumberInStack > num) {
//                        minNumberInStack = num;
//                    }
//                }

//                int minNumberInStack = Collections.min(numbersStack);

                int minNumberInStack = numbersStack.stream().mapToInt(e -> e).min().getAsInt();

                System.out.println(minNumberInStack);
            }
        }

    }
}
