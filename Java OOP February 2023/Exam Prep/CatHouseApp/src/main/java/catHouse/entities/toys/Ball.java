package catHouse.entities.toys;

public class Ball extends BaseToy{
    private final static int BALL_SOFTNESS = 1;
    private final static double BALL_PRICE = 10;
    public Ball() {
        super(BALL_SOFTNESS, BALL_PRICE);
    }
}
