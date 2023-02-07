package P02CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee = null;

            if(data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if(data.length == 5) {
                String parameter = data[4];
                if(parameter.contains("@")) {
                    String email = parameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(parameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (data.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            if(!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }

            departments.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
