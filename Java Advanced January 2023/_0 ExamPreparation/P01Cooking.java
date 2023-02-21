import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        String[] liquids = scanner.nextLine().split(" ");
        String[] ingredients = scanner.nextLine().split(" ");

        for (String liquid : liquids) {
            liquidsQueue.offer(Integer.parseInt(liquid));
        }

        for (String ingredient : ingredients) {
            ingredientsStack.push(Integer.parseInt(ingredient));
        }

        Map<String, Integer> backedFoodsMap = new TreeMap<>();
        backedFoodsMap.put("Bread", 0);
        backedFoodsMap.put("Cake", 0);
        backedFoodsMap.put("Fruit Pie", 0);
        backedFoodsMap.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {


            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            if (liquid + ingredient == 25) {
                backedFoodsMap.put("Bread", backedFoodsMap.get("Bread") + 1);
            } else if (liquid + ingredient == 50) {
                backedFoodsMap.put("Cake", backedFoodsMap.get("Cake") + 1);
            } else if (liquid + ingredient == 75) {
                backedFoodsMap.put("Pastry", backedFoodsMap.get("Pastry") + 1);
            } else if (liquid + ingredient == 100) {
                backedFoodsMap.put("Fruit Pie", backedFoodsMap.get("Fruit Pie") + 1);
            } else {
                ingredientsStack.push(ingredient + 3);
            }
        }

        if (backedFoodsMap.get("Bread") > 0 && backedFoodsMap.get("Cake") > 0 && backedFoodsMap.get("Fruit Pie") > 0 && backedFoodsMap.get("Pastry") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n", liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        backedFoodsMap.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}
