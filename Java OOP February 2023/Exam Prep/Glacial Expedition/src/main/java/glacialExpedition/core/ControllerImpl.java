package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Explorer> explorers;
    private Repository<State> states;
    private Mission mission;
    private int exploredStates;

    public ControllerImpl() {
        this.explorers = new ExplorerRepository();
        this.states = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        switch (type) {
            case "AnimalExplorer":
                explorers.add(new AnimalExplorer(explorerName));
                break;
            case "NaturalExplorer":
                explorers.add(new NaturalExplorer(explorerName));
                break;
            case "GlacierExplorer":
                explorers.add(new GlacierExplorer(explorerName));
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
            states.add(state);
        }
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorers.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorers.remove(explorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        int retiredCount = 0;

        mission = new MissionImpl();

        List<Explorer> explorersOnMission = this.explorers.getCollection().stream()
                .filter(explorer -> explorer.getEnergy() > 50).collect(Collectors.toList());

        if (explorersOnMission.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        mission.explore(this.states.byName(stateName), explorersOnMission);

        for (Explorer explorer : explorersOnMission) {
            if (explorer.getEnergy() == 0) {
                retiredCount++;
            }
        }

        exploredStates++;

        return String.format(STATE_EXPLORER, stateName, retiredCount);
    }

    @Override
    public String finalResult() {
        StringBuilder message = new StringBuilder();

        message.append(String.format(FINAL_STATE_EXPLORED, exploredStates)).append(System.lineSeparator());
        message.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        for (Explorer explorer : explorers.getCollection()) {
            message.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            message.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                message.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                message.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,
                                explorer.getSuitcase().getExhibits()))).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }
}
