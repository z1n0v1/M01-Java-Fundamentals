/*
    https://judge.softuni.org/Contests/Practice/Index/1327#4

    05. Students

Write a program that receives n count of students and orders them by grade (in descending).
Each student should have first name (string), last name (string) and grade (floating-point number).

Input
•	First line will be a number n
•	Next n lines you will get a student info in the format "{first name} {second name} {grade}"

Output
•	Print each student in the following format "{first name} {second name}: {grade}"

 */

package L07ObjectsAndClasses.Exercise.T05Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            students.add(new Student(studentInfo[0],studentInfo[1],Double.parseDouble(studentInfo[2])));
        }
        students.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(students);

        for (Student student : students)
            System.out.println(student);
    }
}
