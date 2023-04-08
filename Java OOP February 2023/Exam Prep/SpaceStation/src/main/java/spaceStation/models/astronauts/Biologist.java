package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private final static double OXYGEN_BIOLOGIST = 70;

    public Biologist(String name) {
        super(name, OXYGEN_BIOLOGIST);
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - 5);
    }
}
