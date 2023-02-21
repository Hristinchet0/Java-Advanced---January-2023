import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();

        String[] textilesInput = scanner.nextLine().split("\\s+");
        String[] medicamentsInput = scanner.nextLine().split("\\s+");

        for (String textile : textilesInput) {
            textilesQueue.offer(Integer.parseInt(textile));
        }

        for (String medicament : medicamentsInput) {
            medicamentsStack.push(Integer.parseInt(medicament));
        }

        Map<Integer, String> itemsMap = new HashMap<>();
        itemsMap.put(30, "Patch");
        itemsMap.put(40, "Bandage");
        itemsMap.put(100, "MedKit");

        Map<String, Integer> collectedItems = new TreeMap<>();


        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {

            int sum = textilesQueue.peek() + medicamentsStack.peek();
            textilesQueue.poll();

            if (itemsMap.containsKey(sum)) {
                String currentItem = itemsMap.get(sum);

                collectedItems.putIfAbsent(currentItem, 0);

                int currentValue = collectedItems.get(currentItem);

                collectedItems.put(currentItem, currentValue + 1);

                medicamentsStack.pop();
            } else if (sum > 100) {

                int medicamentSupplement = (sum - 100);

                medicamentsStack.pop();

                medicamentsStack.push(medicamentSupplement + medicamentsStack.pop());

                collectedItems.putIfAbsent("MedKit", 0);

                int currentValue = collectedItems.get("MedKit");

                collectedItems.put("MedKit", currentValue + 1);
            } else {
                medicamentsStack.push(medicamentsStack.pop() + 10);
            }

        }

        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else  {
            System.out.println("Medicaments are empty.");
        }

        if (collectedItems.size() > 0) {
            collectedItems.entrySet().stream()
                    .sorted((left, right) ->
                            right.getValue() - left.getValue())
                    .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        }


        if(!textilesQueue.isEmpty()){
            System.out.print("Textiles left: ");
            System.out.println(textilesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if(!medicamentsStack.isEmpty())
            System.out.print("Medicaments left: ");
        System.out.println(medicamentsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

}
