package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> tommyGunRepository = mainPlayer.getGunRepository();
        Deque<Gun> tommyGuns = new ArrayDeque<>(tommyGunRepository.getModels());
        Deque<Player> players = new ArrayDeque<>(civilPlayers);

        Player player = players.poll();
        Gun gun = tommyGuns.poll();

        //I phase
        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int shot = gun.fire();
                player.takeLifePoints(shot);
            }

            if (gun.canFire()) {
                player = players.poll();
            } else {
                gun = tommyGuns.poll();
            }
        }

        //II phase
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Repository<Gun> civilPlayerGunRepository = civilPlayer.getGunRepository();
                Deque<Gun> civilPlayersGuns = new ArrayDeque<>(civilPlayerGunRepository.getModels());

                Gun civilPlayerGun = civilPlayersGuns.poll();

                while (civilPlayerGun != null) {
                    while (civilPlayerGun.canFire() && mainPlayer.isAlive()) {
                        int shot = civilPlayerGun.fire();
                        mainPlayer.takeLifePoints(shot);
                    }

                    if (!mainPlayer.isAlive()) {
                        return;
                    }

                    civilPlayerGun = civilPlayersGuns.poll();
                }
            }
        }
    }
}
