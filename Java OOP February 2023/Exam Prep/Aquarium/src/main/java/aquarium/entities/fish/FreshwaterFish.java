package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static final int INCREASE_SIZE = 3;
    private static final int INITIAL_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(INITIAL_SIZE + INCREASE_SIZE);
    }
}
