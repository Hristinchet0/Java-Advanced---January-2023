import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] studentsWithGrades = scanner.nextLine().split("\\s+");
            String name = studentsWithGrades[0];
            double grade = Double.parseDouble(studentsWithGrades[1]);

            studentsMap.putIfAbsent(name, new ArrayList<>());
            studentsMap.get(name).add(grade);
        }

        studentsMap.entrySet()
                .forEach(entry ->  {
                    double sum = 0;
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        sum += entry.getValue().get(j);
                    }
                    double averageGrade = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", averageGrade);
                });
    }
}
