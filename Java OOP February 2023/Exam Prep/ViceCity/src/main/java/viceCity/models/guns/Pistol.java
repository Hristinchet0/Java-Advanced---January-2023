package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_IN_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_IN_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        //1. check if we have bullets in our barrel -> shoot
        //2. if we dont have bullets -> reload
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
