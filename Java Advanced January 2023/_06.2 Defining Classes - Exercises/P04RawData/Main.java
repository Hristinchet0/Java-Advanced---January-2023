package P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            int weight = Integer.parseInt(data[3]);
            String type = data[4];

            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            List<Tire> tireList = new ArrayList<>();

            for (int j = 5; j <= 12; j += 2) {
                double currentTirePressure = Double.parseDouble(data[j]);
                int currentTireAge = Integer.parseInt(data[j + 1]);
                Tire currentTire = new Tire(currentTirePressure, currentTireAge);
                tireList.add(currentTire);
            }

            Car currentCar = new Car(model, engine, cargo, tireList);
            cars.add(currentCar);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    Cargo cargo = car.getCargo();
                    String cargoType = cargo.getType();
                    if (cargoType.equals("fragile")) {
                        List<Tire> tireList = car.getTires();
                        for (int j = 0; j < tireList.size(); j++) {
                            Tire tire = tireList.get(j);
                            double pressure = tire.getPressure();
                            if (pressure < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;

            case "flamable":
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);
                    Cargo cargo = car.getCargo();
                    String cargoType = cargo.getType();
                    if (cargoType.equals("flamable")) {
                        Engine engine = car.getEngine();
                        int enginePower = engine.getPower();
                        if (enginePower > 250) {
                            System.out.println(car.getModel());

                        }
                    }
                }
                break;
        }
    }
}
