package onlineShop.models.products.components;

public class RandomAccessMemory extends BaseComponent{
    public static final double MULTIPLIER = 1.20;
    public RandomAccessMemory(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}
