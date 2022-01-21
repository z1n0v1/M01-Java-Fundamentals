/*
    https://judge.softuni.org/Contests/Practice/Index/1327#6

    07. Order by Age

You will receive an unknown number of lines. On each line, you will receive an array with 3 elements.
The first element will be string and represents the name of the person.
The second element will be a string and will represent the ID of the person.
The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.

 */

package L07ObjectsAndClasses.Exercise.T07OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            people.add(new Person(data[0], data[1], Integer.parseInt(data[2])));
            input = scanner.nextLine();
        }
        people.sort(Comparator.comparing(Person::getAge));

        for (Person person : people)
            System.out.println(person);
    }
}
