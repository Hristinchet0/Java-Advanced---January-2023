package catHouse.entities.toys;

public class Mouse extends BaseToy{
    private final static int MOUSE_SOFTNESS = 5;
    private final static double MOUSE_PRICE = 15;

    public Mouse() {
        super(MOUSE_SOFTNESS, MOUSE_PRICE);
    }
}
