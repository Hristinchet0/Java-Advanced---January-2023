import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> valuesWithOccurrences = new LinkedHashMap<>();

        for (Double number : numbers) {
            double currentNumber = number;

            if(valuesWithOccurrences.containsKey(currentNumber)) {
                Integer count = valuesWithOccurrences.get(currentNumber);
                valuesWithOccurrences.put(currentNumber, count + 1);
            } else {
                valuesWithOccurrences.put(currentNumber, 1);
            }
        }
        for (Double key : valuesWithOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", key, valuesWithOccurrences.get(key));
        }
    }
}
