import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> guests = new TreeSet<>();

        while (!input.equals("PARTY")) {
            guests.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            guests.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(guests.size());
        guests.forEach(guest -> System.out.println(guest));
    }
}
