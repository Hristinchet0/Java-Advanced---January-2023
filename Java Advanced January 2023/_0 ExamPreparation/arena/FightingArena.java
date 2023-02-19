package arena;

import java.util.ArrayList;
import java.util.List;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.gladiators =  new ArrayList<>();
        this.name = name;
    }

    public void add(Gladiator gladiator) {
        this.gladiators.add(gladiator);
    }

    public void remove(String name) {
        this.gladiators.removeIf(gladiator -> gladiator.getName().equals(name));
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        Gladiator gladiator = null;
        int maxStatPower = -1;

        for (Gladiator g : gladiators) {
            if(g.getStatPower() > maxStatPower) {
                maxStatPower = g.getStatPower();
                gladiator = g;
            }
        }
        return gladiator;
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        Gladiator gladiator = null;
        int maxWeaponPower = -1;

        for (Gladiator g : gladiators) {
            if(g.getWeaponPower() > maxWeaponPower) {
                maxWeaponPower = g.getWeaponPower();
                gladiator = g;
            }
        }

        return gladiator;
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        Gladiator gladiator = null;
        int maxTotalPower = -1;

        for (Gladiator g : gladiators) {
            if(g.getTotalPower() > maxTotalPower) {
                maxTotalPower = g.getTotalPower();
                gladiator = g;
            }
        }

        return gladiator;
    }

    public int getCount() {
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s - %d gladiators are participating.", this.name, this.getCount());
    }
}
