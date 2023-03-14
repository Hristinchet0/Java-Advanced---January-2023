package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();
        while (!animalType.equals("Beast!")) {
            String[] animalParameter = scanner.nextLine().split("\\s+");

            Animal animal = null;
            try {
                animal = parseAnimal(animalType, animalParameter);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

            if(animal != null) {
                System.out.println(animal.toString());
            }


            animalType = scanner.nextLine();
        }
    }

    private static Animal parseAnimal(String animalType, String[] animalParameter) {
        switch (animalType) {
            case "Cat":
                return new Cat(animalParameter[0], Integer.parseInt(animalParameter[1]), animalParameter[2]);
            case "Dog":
                return new Dog(animalParameter[0], Integer.parseInt(animalParameter[1]), animalParameter[2]);
            case "Frog":
                return new Frog(animalParameter[0], Integer.parseInt(animalParameter[1]), animalParameter[2]);
            case "Kitten":
                return new Kitten(animalParameter[0], Integer.parseInt(animalParameter[1]));
            case "Tomcat":
                return new Tomcat(animalParameter[0], Integer.parseInt(animalParameter[1]));
            default:
                throw new IllegalStateException("Unknown animal: " + animalType);
        }
    }
}
