import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] parts = input.split(", ");
            String direction = parts[0];
            String carNumber = parts[1];

            if(direction.equals("IN")) {
                cars.add(carNumber);
            }else if (direction.equals("OUT")) {
                cars.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if(cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }

            //cars.forEach(car -> System.out.println(car));
        }
    }
}
