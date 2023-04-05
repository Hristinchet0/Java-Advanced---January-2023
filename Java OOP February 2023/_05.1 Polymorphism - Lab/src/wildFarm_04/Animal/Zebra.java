package wildFarm_04.Animal;

import wildFarm_04.food.Food;
import wildFarm_04.food.Vegetable;

public class Zebra extends Mammal{
    public Zebra(String name, double weight, String region) {
        super(name, weight, region, AnimalType.Zebra);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Vegetable;
    }

}
