/*
    https://judge.softuni.org/Contests/Practice/Index/1328#0

    01. Company Roster

Define a class Employee that holds the following information: name, salary, position, department, email and age.
The name, salary, position and department are mandatory while the rest are optional.
Your task is to write a program which takes N lines of employees from the console and calculates the department
with the highest average salary and prints for each employee in that department his name, salary,
email and age – sorted by salary in descending order.
If an employee doesn’t have an email – in place of that field you should print “n/a” instead, if he doesn’t have an age
– print “-1” instead. The salary should be printed to two decimal places after the seperator.

Hint: you can define a Department class that holds list of employees.

 */

package L07ObjectsAndClasses.Exercise.More.T01CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Department> departments;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        departments = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Employee employee;
            String[] data = scanner.nextLine().split("\\s+");

            double salary = Double.parseDouble(data[1]);

            if (data.length == 6) {
                employee = new Employee(data[0], salary, data[2], data[3], data[4], Integer.parseInt(data[5]));
            } else if (data.length == 5) {
                if (data[4].contains("@"))
                    employee = new Employee(data[0], salary, data[2], data[3], data[4]);
                else employee = new Employee(data[0], salary, data[2], data[3], Integer.parseInt(data[4]));
            } else employee = new Employee(data[0], salary, data[2], data[3]);

            addEmployee(employee);
        }

        Department highestSalaryDepartment = getHighestSalaryDepartment();

        System.out.println("Highest Average Salary: " + highestSalaryDepartment.name);
        highestSalaryDepartment.printEmployees();
    }

    static Department getHighestSalaryDepartment() {
        departments.sort(Comparator.comparing(Department::getAverageSalary));
        return departments.get(departments.size()-1); // Last element is with the highest avg. salary.
    }

    static void addEmployee(Employee employee) {
        boolean departmentExists = false;

        for (Department department : departments) {
            if(department.getName().equals(employee.getDepartment())) {
                department.addEmployee(employee);
                departmentExists = true;
            }
        }
        if (!departmentExists) {
            Department department = new Department(employee.getDepartment());
            department.addEmployee(employee);
            departments.add(department);
        }
    }
}
