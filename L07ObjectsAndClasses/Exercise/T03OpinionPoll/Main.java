/*
    https://judge.softuni.org/Contests/Practice/Index/1327#2

    03. Opinion Poll

Using the Person class, write a program that reads from the console N lines of personal information
and then prints all people whose age is more than 30 years, sorted in alphabetical order.

Note: you can use stream() to filter people.
 */

package L07ObjectsAndClasses.Exercise.T03OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            people.add(new Person(input[0],Integer.parseInt(input[1])));
        }
        people = people.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
        people.sort(Comparator.comparing(Person::getName));

        for (Person person : people)
            System.out.println(person.getName() + " - " + person.getAge());
    }
}
