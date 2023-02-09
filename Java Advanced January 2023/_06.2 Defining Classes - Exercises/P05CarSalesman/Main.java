package P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int enginesCount = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 1; i <= enginesCount; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            //displacement and efficiency are optional
            int displacement = 0;
            String efficiency = null;

            if(engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if(Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int carsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= carsCount; i++) {
            String[] carsData = scanner.nextLine().split("\\s+");
            String carModel = carsData[0];
            String engineModel = carsData[1];
            //weight and color are optional
            int weight = 0;
            String color = null;

            if(carsData.length == 4) {
                weight = Integer.parseInt(carsData[2]);
                color = carsData[3];
            } if (carsData.length == 3) {
                if(Character.isDigit(carsData[2].charAt(0))) {
                    weight = Integer.parseInt(carsData[2]);
                } else {
                    color = carsData[2];
                }
            }

            Engine carEngine = null;
            for (Engine engine : engines) {
                if(engineModel.equals(engine.getModel())) {
                    carEngine = engine;
                }

            }

            Car car = new Car(carModel, carEngine, weight, color);
            System.out.println(car.toString());

        }
    }
}
