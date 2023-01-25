import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> usersMap = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
            String message = input.split("\\s+")[1].split("=")[1];
            String username = input.split("\\s+")[2].split("=")[1];
            usersMap.putIfAbsent(username, new LinkedHashMap<>());
            usersMap.get(username).putIfAbsent(ip, 0);
            usersMap.get(username).put(ip, usersMap.get(username).get(ip) + 1);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> user : usersMap.entrySet()) {
            String person = user.getKey();
            Map<String, Integer> ipMap = user.getValue();
            System.out.println(person + ": ");
            int counter = ipMap.size() - 1;
            for (String ip : ipMap.keySet()) {
                if (counter == 0) {
                    System.out.print(ip + " => " + ipMap.get(ip) + ".");
                    System.out.println();
                } else {
                    System.out.print(ip + " => " + ipMap.get(ip) + ", ");
                }
                counter--;
            }
        }
    }
}