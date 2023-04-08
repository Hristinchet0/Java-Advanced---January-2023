package viceCity.models.players;

public class MainPlayer extends BasePlayer{
    private static final int MAIN_PLAYER_POINTS = 100;
    private static final String MAIN_PLAYER_NAME = "Tommy Vercetti";
    public MainPlayer() {
        super(MAIN_PLAYER_NAME, MAIN_PLAYER_POINTS);
    }
}
