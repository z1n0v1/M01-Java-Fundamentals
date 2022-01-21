/*
    https://judge.softuni.org/Contests/Practice/Index/1312#7

    08. Company Users

Write a program which keeps information about companies and their employees.
You will receive company name and employee's id, until you receive the command "End".
Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.
When you finish reading data, order the companies by the name in ascending order.
Print the company name and each employee's id in the following format:
{companyName}
-- {id1}
-- {id2}
-- {idN}

Input / Constraints
•	Until you receive "End", the input come in the format: "{companyName} -> {employeeId}"
•	The input always will be valid

 */

package L08AssociativeArrays.Exercise.T08CompanyUsers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, List<String>> companies = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String [] data = input.split(" -> ");
            if(companies.containsKey(data[0])) {
                List<String> employees = companies.get(data[0]);
                if (!employees.contains(data[1]))
                    employees.add(data[1]);
            } else  {
                List<String> employees = new ArrayList<>();
                employees.add(data[1]);
                companies.put(data[0], employees);
            }
            input = scanner.nextLine();
        }

        companies.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(company -> {
                    System.out.println(company.getKey());
                    company.getValue().forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
