import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputMaterials = scanner.nextLine().split(" ");
        String[] inputMagicLevel = scanner.nextLine().split(" ");

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();

        for (String inputMaterial : inputMaterials) {
            materialsStack.push(Integer.parseInt(inputMaterial));
        }

        for (String magic : inputMagicLevel) {
            magicLevelQueue.offer(Integer.parseInt(magic));
        }

        Map<String, Integer> presentMap = new TreeMap<>();
        presentMap.put("Doll", 0);
        presentMap.put("Wooden train", 0);
        presentMap.put("Teddy bear", 0);
        presentMap.put("Bicycle", 0);

        while (!(materialsStack.isEmpty() || magicLevelQueue.isEmpty())) {

            if (materialsStack.peek() == 0) {
                materialsStack.pop();

            }

            if (magicLevelQueue.peek() == 0) {
                magicLevelQueue.poll();

            }

            if (materialsStack.isEmpty() || magicLevelQueue.isEmpty()) {
                break;
            }

            int material = materialsStack.pop();
            int magicLvl = magicLevelQueue.poll();
            int totalMaterials = material * magicLvl;

            switch (totalMaterials) {
                case 150:
                    presentMap.put("Doll", presentMap.get("Doll") + 1);
                    break;
                case 250:
                    presentMap.put("Wooden train", presentMap.get("Wooden train") + 1);
                    break;
                case 300:
                    presentMap.put("Teddy bear", presentMap.get("Teddy bear") + 1);
                    break;
                case 400:
                    presentMap.put("Bicycle", presentMap.get("Bicycle") + 1);
                    break;
                default:
                    if (totalMaterials < 0) {
                        materialsStack.push(material + magicLvl);
                    } else {
                        materialsStack.push(material + 15);
                    }

            }

        }

        if((presentMap.get("Doll")>0 && presentMap.get("Wooden train")>0) || (presentMap.get("Teddy bear")>0 && presentMap.get("Bicycle")>0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if(!materialsStack.isEmpty()) {
            System.out.printf("Materials left: %s%n", materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(!magicLevelQueue.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicLevelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        presentMap.entrySet().stream().filter(s -> s.getValue() > 0).forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));

    }
}
