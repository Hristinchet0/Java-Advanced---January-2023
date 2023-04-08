package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_IN_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_IN_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }

        setBulletsPerBarrel((getBulletsPerBarrel() - BULLETS_PER_SHOT));

        return BULLETS_PER_SHOT;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - BULLETS_IN_BARREL);
        setBulletsPerBarrel(BULLETS_IN_BARREL);
    }
}
