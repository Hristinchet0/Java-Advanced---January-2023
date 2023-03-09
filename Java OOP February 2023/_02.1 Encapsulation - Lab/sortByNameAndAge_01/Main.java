package sortByNameAndAge_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Person personToAdd = new Person(firstName, lastName, age);
            people.add(personToAdd);
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
            int comparisonResult = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

//            if (comparisonResult != 0) {
//                return comparisonResult;
//            } else {
//                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
//            }

            if(comparisonResult == 0) {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }

            return comparisonResult;
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}
