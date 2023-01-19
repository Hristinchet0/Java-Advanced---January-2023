import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shopProducts = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shopName = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            shopProducts.putIfAbsent(shopName, new LinkedHashMap<>());
            shopProducts.get(shopName).put(product, price);


            input = scanner.nextLine();
        }

        System.out.println(shopProducts.entrySet()
                .stream()
                .map(shop ->
                        String.format("%s->%n%s", shop.getKey(),
                                shop.getValue()
                                        .entrySet()
                                        .stream()
                                        .map(product ->
                                                String.format("Product: %s, Price: %.1f",
                                                        product.getKey(),
                                                        product.getValue()))
                                        .collect(Collectors.joining(System.lineSeparator()))
                        )
                )
                .collect(Collectors.joining(System.lineSeparator())));


    }
}
