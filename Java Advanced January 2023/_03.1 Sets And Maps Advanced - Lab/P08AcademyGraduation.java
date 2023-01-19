//40/100 wrong type number

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> graduationList = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] gradesList = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[gradesList.length];

            for (int j = 0; j < gradesList.length; j++) {
                grades[j] = Double.parseDouble(gradesList[j]);
            }

            graduationList.put(name, grades);
        }


        DecimalFormat format = new DecimalFormat("0.##########");
        for (String studentName : graduationList.keySet()) {
            Double[] grades = graduationList.get(studentName);

            double sum = 0;

            for (Double grade : grades) {
                sum += grade;
            }

            System.out.printf("%s is graduated with %s%n", studentName, format.format(sum / grades.length));
        }

    }
}
