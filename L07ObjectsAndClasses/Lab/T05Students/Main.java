/*
    https://judge.softuni.org/Contests/Practice/Index/1319#4

    05. Students

Define a class Student, which holds the following information about students: first name, last name, age and hometown.
Read list of students until you receive "end" command. After that, you will receive a city name.
Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".

 */

package L07ObjectsAndClasses.Lab.T05Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> students;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        students = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            input = scanner.nextLine();
        }
        printStudents(scanner.nextLine());
    }

    private static void printStudents(String town) {
        for (Student student : students)
            if(student.getHomeTown().equals(town))
                System.out.println(student);
    }
}
