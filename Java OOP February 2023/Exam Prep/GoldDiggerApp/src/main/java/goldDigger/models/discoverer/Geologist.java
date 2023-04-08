package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer{
    private final static double INITIAL_ENERGY = 100;
    public Geologist(String name) {
        super(name, INITIAL_ENERGY);
    }
}
