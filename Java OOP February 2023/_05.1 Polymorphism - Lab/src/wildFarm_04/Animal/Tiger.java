package wildFarm_04.Animal;

import wildFarm_04.food.Food;
import wildFarm_04.food.Meat;

public class Tiger extends Feline {

    public Tiger(String name, double weight, String region) {
        super(name, weight, region, AnimalType.Tiger);
    }


    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Meat;
    }


}
