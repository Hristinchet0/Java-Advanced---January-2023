package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        //Biologist, Geodesist, Meteorologist
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                String msg = String.format(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
                throw new IllegalArgumentException(msg);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        List<String> itemsList = Arrays.asList(items);
        planet.getItems().addAll(itemsList);

        this.planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.getModels().stream().noneMatch(a -> a.getName().equals(astronautName))) {
            String msg = String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName);
            throw new IllegalArgumentException(msg);
        }

        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        this.astronautRepository.remove(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        List<Astronaut> suitableAstronauts = this.astronautRepository.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        int countBeforeMission = suitableAstronauts.size();

        Mission mission = new MissionImpl();
        Planet planet = new PlanetImpl(planetName);
        mission.explore(planet, suitableAstronauts);
        exploredPlanets++;

        int countAfterMission = suitableAstronauts.size();

        int astronautsDead = countBeforeMission - countAfterMission;

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, astronautsDead);
    }

    @Override
    public String report() {
        StringBuilder message = new StringBuilder();
        message.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator());
        message.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

        this.astronautRepository.getModels().forEach(a -> {
            message.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, a.getName())).append(System.lineSeparator());
            message.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, a.getOxygen())).append(System.lineSeparator());
            if (a.getBag().getItems().size() == 0) {
                message.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
            } else {
                Collection<String> items = a.getBag().getItems();
                message.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, items))).append(System.lineSeparator());
            }
        });
        return message.toString().trim();
    }
}
