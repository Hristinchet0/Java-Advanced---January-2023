package onlineShop.models.products.components;

public class Motherboard extends BaseComponent{
    public static final double MULTIPLIER = 1.25;
    public Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}
