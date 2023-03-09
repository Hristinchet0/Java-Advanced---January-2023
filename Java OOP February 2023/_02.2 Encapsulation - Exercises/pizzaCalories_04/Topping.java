package pizzaCalories_04;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies")
                || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
    }


    public double calculateCalories() {
        double toppingCoefficient = 0;

        if(this.toppingType.equals("Meat")) {
            toppingCoefficient = 1.2;
        } else if(this.toppingType.equals("Veggies")) {
            toppingCoefficient = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            toppingCoefficient = 1.1;
        } else if (this.toppingType.equals("Sauce")) {
            toppingCoefficient = 0.9;
        }

        return 2 * this.weight * toppingCoefficient;
    }
}
