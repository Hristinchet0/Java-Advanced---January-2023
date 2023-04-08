package aquarium.entities.decorations;

public abstract class BaseDecoration implements Decoration {
    private int comfort;
    private double price;

    public BaseDecoration(int comfort, double price) {
        this.setComfort(comfort);
        this.setPrice(price);
    }
    @Override
    public int getComfort() {
        return comfort;
    }
    @Override
    public double getPrice() {
        return price;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}