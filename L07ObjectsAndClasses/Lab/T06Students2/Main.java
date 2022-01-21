/*
    https://judge.softuni.org/Contests/Practice/Index/1319#5

    06. Students 2.0

Use the class from the previous problem.

(Define a class Student, which holds the following information about students: first name, last name, age and hometown.)
(Read list of students until you receive "end" command. After that, you will receive a city name.)
(Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old".)

If you receive a student which already exists (first name and last name should be unique) overwrite the information.
 */

package L07ObjectsAndClasses.Lab.T06Students2;

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
            Student student = getStudent(data[0], data[1]);

            if(student == null)
                students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            else {
                student.setAge(Integer.parseInt(data[2]));
                student.setHomeTown(data[3]);
            }

            input = scanner.nextLine();
        }
        printStudents(scanner.nextLine());
    }

    private static Student getStudent (String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                return student;
        }
        return null;

    }

    private static void printStudents(String town) {
        for (Student student : students)
            if(student.getHomeTown().equals(town))
                System.out.println(student);
    }
}
