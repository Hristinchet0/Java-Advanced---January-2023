import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effects = new ArrayDeque<>();
        String[] effectsInfo = scanner.nextLine().split(", ");
        for (String s : effectsInfo) {
            Integer parseInt = Integer.parseInt(s);
            effects.add(parseInt);
        }

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        String[] castingsInfo = scanner.nextLine().split(", ");

        for (String s : castingsInfo) {
            Integer parseInt = Integer.parseInt(s);
            casings.push(parseInt);
        }

        Map<String, Integer> makedBombs = new TreeMap<>();
        makedBombs.put("Datura Bombs", 0);
        makedBombs.put("Cherry Bombs", 0);
        makedBombs.put("Smoke Decoy Bombs", 0);

        boolean makeAllBombs = false;

        while (!(effects.isEmpty() || casings.isEmpty() || makeAllBombs)) {

            int singleEffects = effects.peek();
            int singleCasings = casings.pop();
            int totalMaterial = singleEffects + singleCasings;

            switch (totalMaterial) {
                case 40:
                    makedBombs.put("Datura Bombs", makedBombs.get("Datura Bombs") + 1);
                    effects.poll();
                    break;
                case 60:
                    makedBombs.put("Cherry Bombs", makedBombs.get("Cherry Bombs") + 1);
                    effects.poll();
                    break;
                case 120:
                    makedBombs.put("Smoke Decoy Bombs", makedBombs.get("Smoke Decoy Bombs") + 1);
                    effects.poll();
                    break;
                default:
                    casings.push(singleCasings - 5);
            }

            makeAllBombs = isMaked(makedBombs);

        }

        if (makeAllBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        String remainingBombEffects = effects.isEmpty() ? "empty" : effects.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Effects: " + remainingBombEffects);

        String remainingBombCastings = casings.isEmpty() ? "empty" : casings.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Casings: " + remainingBombCastings);

        makedBombs.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static boolean isMaked(Map<String, Integer> makeBombs) {
        int count = 0;
        for (Integer n : makeBombs.values()) {
            if (n >= 3) {
                count++;
            }
        }
        return count == 3;
    }
}
