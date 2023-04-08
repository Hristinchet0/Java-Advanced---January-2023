package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;
    

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;

        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);

    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
                decorations.remove(decoration);
            }
        }

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.stream().filter(aqua -> aqua.getName().equals(aquariumName))
                .findFirst().orElse(null);

        String aquariumType = aquarium.getClass().getSimpleName();

        boolean suitable = ((aquariumType.equals("FreshwaterAquarium")) && fishType.equals("FreshwaterFish")) ||
                (aquariumType.equals("SaltwaterAquarium")) && fishType.equals("SaltwaterFish");

        if (suitable) {
            aquarium.addFish(fish);
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fish.getClass().getSimpleName(), aquariumName);
        } else {
            return WATER_NOT_SUITABLE;
        }
    }

    @Override
    public String feedFish(String aquariumName) {

        int countFedFish = 0;

        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                Collection<Fish> fishes = aquarium.getFish();
                for (Fish fish : fishes) {
                    fish.eat();
                    countFedFish++;
                }
            }
        }

        return String.format(FISH_FED, countFedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().findFirst()
                .filter(aquarium1 -> aquarium1.getName().equals(aquariumName)).orElse(null);

        double totalFishAndDecorationsValue = 0;

        Collection<Decoration> decorations = aquarium.getDecorations();
        for (Decoration decoration : decorations) {
            totalFishAndDecorationsValue += decoration.getPrice();
        }

        Collection<Fish> fish = aquarium.getFish();
        for (Fish fish1 : fish) {
            totalFishAndDecorationsValue += fish1.getPrice();
        }

        return String.format(VALUE_AQUARIUM, aquariumName, totalFishAndDecorationsValue);
    }

    @Override
    public String report() {
        StringBuilder message = new StringBuilder();

        for (Aquarium aquarium : aquariums) {
            message.append(aquarium.getInfo()).append(System.lineSeparator());
        }

        return message.toString().trim();
    }
}
