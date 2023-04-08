package magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    private final static int FIRE_BULLETS = 10;
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() < FIRE_BULLETS) {
            return 0;
        }
        setBulletsCount(getBulletsCount() - FIRE_BULLETS);
        return FIRE_BULLETS;
    }
}
