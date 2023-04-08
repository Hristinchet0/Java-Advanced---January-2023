package viceCity.models.players;

public class CivilPlayer extends BasePlayer{
    private static final int CIVIL_PLAYER_POINTS = 50;

    public CivilPlayer(String name) {
        super(name, CIVIL_PLAYER_POINTS);
    }
}
