package onlineShop.models.products.components;

public class VideoCard extends BaseComponent{
    public static final double MULTIPLIER = 1.15;
    public VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}
