package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{

    private static final int INCREASE_SIZE = 2;
    private static final int INITIAL_SIZE = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(INITIAL_SIZE + INCREASE_SIZE);
    }
}
