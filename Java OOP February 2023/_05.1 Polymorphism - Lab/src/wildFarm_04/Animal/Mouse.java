package wildFarm_04.Animal;

import wildFarm_04.food.Food;
import wildFarm_04.food.Vegetable;

public class Mouse extends Mammal{
    public Mouse(String name, double weight, String region) {
        super(name, weight, region, AnimalType.Mouse);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Vegetable;
    }

}
