package P06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            pokemonByTrainers.putIfAbsent(data[0], new ArrayList<>());
            pokemonByTrainers.get(data[0]).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainerList = pokemonByTrainers.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {


            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(command);
            }
            command = scanner.nextLine();
        }

        trainerList.stream()
                .sorted(Comparator.comparingInt((Trainer trainer) -> trainer.getBadges()).reversed())
                .forEach(System.out::println);

    }
}
