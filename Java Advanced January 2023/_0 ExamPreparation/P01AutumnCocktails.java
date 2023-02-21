import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> ingredientsQueue = new ArrayDeque<>();
        Stack<Integer> freshnessStack = new Stack<>();

        String[] ingredients = scanner.nextLine().split(" ");
        String[] freshness = scanner.nextLine().split(" ");

        for (String ingredient : ingredients) {
            ingredientsQueue.offer(Integer.parseInt(ingredient));
        }

        for (String fresh : freshness) {
            freshnessStack.push(Integer.parseInt(fresh));
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        Map<String, Integer> cocktailsMap = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {

            int ingredient = ingredientsQueue.peek();
            int fresh = freshnessStack.peek();

            if (ingredient == 0) {
                ingredientsQueue.poll();
                continue;
            }

            if (ingredient * fresh == 150) {
                pearSour++;
                ingredientsQueue.poll();
                freshnessStack.pop();
                cocktailsMap.put("Pear Sour", pearSour);
            } else if (ingredient * fresh == 250) {
                theHarvest++;
                ingredientsQueue.poll();
                freshnessStack.pop();
                cocktailsMap.put("The Harvest", theHarvest);
            } else if (ingredient * fresh == 300) {
                appleHinny++;
                ingredientsQueue.poll();
                freshnessStack.pop();
                cocktailsMap.put("Apple Hinny", appleHinny);
            } else if (ingredient * fresh == 400) {
                highFashion++;
                ingredientsQueue.poll();
                freshnessStack.pop();
                cocktailsMap.put("High Fashion", highFashion);
            } else {
                freshnessStack.pop();
                int toIncrease = ingredientsQueue.poll();
                ingredientsQueue.offer(toIncrease + 5);
            }
        }

        int sum = 0;

        if (!ingredientsQueue.isEmpty()) {
            for (Integer ingredient : ingredientsQueue) {
                sum += ingredient;
            }
        }

        if (pearSour != 0 && theHarvest != 0 && appleHinny != 0 && highFashion != 0) {
            System.out.println("It's party time! The cocktails are ready!");
            if (sum != 0) {
                System.out.println("Ingredients left: " + sum);
            }

            for (Map.Entry<String, Integer> cocktail : cocktailsMap.entrySet()) {
                System.out.printf(" # %s --> %d%n", cocktail.getKey(), cocktail.getValue());
            }
        }  else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if (sum != 0) {
                System.out.println("Ingredients left: " + sum);
            }

            for (Map.Entry<String, Integer> cocktail : cocktailsMap.entrySet()) {
                System.out.printf(" # %s --> %d%n", cocktail.getKey(), cocktail.getValue());
            }
        }


    }
}

