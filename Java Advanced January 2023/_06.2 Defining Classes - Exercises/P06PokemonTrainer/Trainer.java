package P06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.badges = badges;
        this.pokemonList = pokemonList;
    }

    public int getBadges() {
        return badges;
    }


    public void commandExecuting(String command) {

        if (isExist(command)) {
            badges += 1;
        } else {

            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + pokemonList.size();
    }
}
