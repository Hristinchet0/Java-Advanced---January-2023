package pizzaCalories_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pizzaData = scanner.nextLine();
        String pizzaName = pizzaData.split(" ")[1];
        int toppingsNumber = Integer.parseInt(pizzaData.split(" ")[2]);
        Pizza pizza = new Pizza(pizzaName, toppingsNumber);

        String doughData = scanner.nextLine();
        String flourType = doughData.split(" ")[1];
        String backingTechnique = doughData.split(" ")[2];
        double doughWeight = Double.parseDouble(doughData.split(" ")[3]);
        Dough dough = new Dough(flourType, backingTechnique, doughWeight);

        pizza.setDough(dough);

        String toppingData = scanner.nextLine();

        while (!toppingData.equals("END")) {
            String toppingType = toppingData.split(" ")[1];
            double toppingWeight = Double.parseDouble(toppingData.split(" ")[2]);

            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);

            toppingData = scanner.nextLine();
        }

        try {
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
