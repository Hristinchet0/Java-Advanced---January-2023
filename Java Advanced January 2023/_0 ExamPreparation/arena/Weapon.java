package arena;

public class Weapon {
    private int size;
    private int solidity;
    private int sharpness;

    public Weapon(int size, int solidity, int sharpness) {
        this.size = size;
        this.solidity = solidity;
        this.sharpness = sharpness;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSolidity() {
        return solidity;
    }

    public void setSolidity(int solidity) {
        this.solidity = solidity;
    }

    public int getSharpness() {
        return sharpness;
    }

    public void setSharpness(int sharpness) {
        this.sharpness = sharpness;
    }
}
