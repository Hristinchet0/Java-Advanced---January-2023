package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{

    private final static double OXYGEN_GEODESIST = 50;

    public Geodesist(String name) {
        super(name, OXYGEN_GEODESIST);
    }

}
