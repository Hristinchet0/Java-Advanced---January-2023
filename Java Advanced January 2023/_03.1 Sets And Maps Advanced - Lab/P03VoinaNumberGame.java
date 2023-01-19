import java.util.*;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();

        String[] input1 = scanner.nextLine().split("\\s+");
        for (String value : input1) {
            int current = Integer.parseInt(value);
            deckOne.add(current);
        }

        String[] input2 = scanner.nextLine().split("\\s+");
        for (String s : input2) {
            int current = Integer.parseInt(s);
            deckTwo.add(current);
        }

        for (int step = 0; step < 50; step++) {
            if (deckOne.isEmpty()) {
                break;
            } else if (deckTwo.isEmpty()) {
                break;
            }

            Integer fighterOne = deckOne.iterator().next(); // .get(0);
            Integer fighterTwo = deckTwo.iterator().next();

            deckOne.remove(fighterOne);
            deckTwo.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterTwo > fighterOne) {
                // <=
                deckTwo.add(fighterOne);
                deckTwo.add(fighterTwo);
            }
        }

        if (deckOne.size() < deckTwo.size()) {
            System.out.println("Second player win!");
        } else if (deckTwo.size() < deckOne.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
