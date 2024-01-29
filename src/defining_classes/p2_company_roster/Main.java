package defining_classes.p2_company_roster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee;

            switch (tokens.length) {
                case 4:
                    employee = new Employee(name,
                                            salary,
                                            position,
                                            department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        employee = new Employee(name,
                                                salary,
                                                position,
                                                department,
                                                Integer.parseInt(tokens[4]));
                    } else {
                        employee = new Employee(name,
                                                salary,
                                                position,
                                                department,
                                                tokens[4]);
                    }
                    break;
                default:
                    employee = new Employee(name,
                                            salary,
                                            position,
                                            department,
                                            tokens[4],
                                            Integer.parseInt(tokens[5]));
                    break;
            }

            employeeList.add(employee);
        }

        // Правим Map<Department, List<Employee>>
        Map<String, List<Employee>> departmentMap =
        employeeList.stream()
                    .collect(groupingBy(Employee::getDepartment));


        Map.Entry<String, List<Employee>> highestSalaryDepartment =
        departmentMap.entrySet()
                     .stream()
                     .sorted((entry1, entry2) -> {
                         double e1AvgSalary = entry1.getValue()
                                                .stream()
                                                .mapToDouble(Employee::getSalary)
                                                .average()
                                                .getAsDouble();

                         double e2AvgSalary = entry2.getValue()
                                                .stream()
                                                .mapToDouble(Employee::getSalary)
                                                .average()
                                                .getAsDouble();

                         return Double.compare(e2AvgSalary, e1AvgSalary);
                     })
                     .findFirst()
                     .orElse(null);

        System.out.printf("Highest Average Salary: %s\n", highestSalaryDepartment.getKey());
        highestSalaryDepartment.getValue()
                               .stream()
                               .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                               .forEach(System.out::println);

    }
}
