package L07ObjectsAndClasses.Exercise.More.T01CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Department {
    String name;
    double budget;
    int numEmployees;
    List<Employee> employees;



    public boolean equals(Object o) {
        if (o instanceof Department) {
            Department department = (Department) o;
            if(department.name.equals(name))
                return true;
        }
        return false;
    }

    public Department() {
        numEmployees = 0;
        budget = 0;
        employees = new ArrayList<>();
    }

    public Department(String name) {
        this();
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printEmployees () {
        employees.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(employees);

        for (Employee employee : employees)
            System.out.println(employee);
    }

    public double getAverageSalary() {
        if(numEmployees > 0)
            return budget / numEmployees;
        return 0;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        numEmployees++;
        budget+= employee.getSalary();
    }


}
