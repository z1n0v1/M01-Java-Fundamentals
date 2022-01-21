/*
    https://judge.softuni.org/Contests/Practice/Index/1312#6

    07. Student Academy

Write a program, which keeps information about students and their grades.
On the first line you will receive number n. After that you will receive n pair of rows.
First you will receive the student's name, after that you will receive his grade.
Check if student already exists, and if not - add him. Keep track of all grades for each student.
When you finish reading data, keep students with average grade higher or equal to 4.50.
Order filtered students by average grade in descending order.

Print the students and their average grade in format:
"{name} –> {averageGrade}"
Format the average grade to the 2nd decimal place.
 */

package L08AssociativeArrays.Exercise.T07StudentAcademy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();

        int numStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numStudents; i++) {
            String studentName = scanner.nextLine();
            Double studentGrade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(studentName)) {
                List<Double> grades = new ArrayList<>();
                grades.add(studentGrade);
                students.put(studentName, grades);
            } else {
                students.get(studentName).add(studentGrade);
            }
        }

        LinkedHashMap<String,Double> studentsAverageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            double averageGrade = student.getValue().stream().mapToDouble(a -> a).average().getAsDouble();
            studentsAverageGrade.put(student.getKey(), averageGrade);
        }

        studentsAverageGrade.entrySet().stream().sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .filter(student -> student.getValue() >= 4.5)
                .forEach(student -> System.out.printf("%s -> %.2f%n",student.getKey(),student.getValue()));

//        students.entrySet().stream().sorted((a,b) -> {
//
//        });
    }
}
