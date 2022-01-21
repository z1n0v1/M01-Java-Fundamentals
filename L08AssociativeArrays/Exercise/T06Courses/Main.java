/*
    https://judge.softuni.org/Contests/Practice/Index/1312#5

    06. Courses

Write a program, which keeps information about courses. Each course has a name and registered students.
You will receive course name and student name, until you receive the command "end".
Check if such course already exists, and if not - add the course. Register the user into the course.
When you do receive the command "end", print the courses with their names and total registered users,
ordered by the count of registered users in descending order.
For each contest print registered users ordered by name in ascending order.

Input
•	Until you receive "end", the input come in the format: "{courseName} : {studentName}"
•	The product data is always delimited by " : "

Output
•	Print information about each course, following the format:
"{courseName}: {registeredStudents}"
•	Print information about each student, following the format:
"-- {studentName}"

 */

package L08AssociativeArrays.Exercise.T06Courses;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] data = input.split("\\s*:\\s*");


            if (courses.containsKey(data[0])) {
                courses.get(data[0]).add(data[1]);
            } else {
                List<String> students = new ArrayList<>();
                students.add(data[1]);
                courses.put(data[0], students);
            }
            input = scanner.nextLine();
        }

        courses.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(course -> {
                    System.out.printf("%s: %d%n", course.getKey(), course.getValue().size());
                    course.getValue().stream().sorted().forEach(studentName -> System.out.println("-- " + studentName));
                });

//                    course.getValue().sort(String::compareTo);
//
//                    for (String person : course.getValue())
//                        System.out.printf("-- %s%n", person);
//                });

//        for (Map.Entry<String, List<String>> course : courses.entrySet()) {
//            course.getValue().sort(String::compareTo);
//            System.out.printf("%s: %d%n",course.getKey(),course.getValue().size());
//            for (String person : course.getValue()) {
//                System.out.printf("-- %s", person);
//            }
//        }

//        Set<Map.Entry<String, List<String>>> coursesSet = courses.entrySet();
//
//        List<Map.Entry<String, List<String>>> coursesList = new ArrayList<>(coursesSet);
//
//        coursesList.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());
//
//        for (Map.Entry<String, List<String>> course : coursesList) {
//            System.out.printf("%s: %d%n", course.getKey(), course.getValue().size());
//            Collections.sort(course.getValue());
//            for (String student : course.getValue())
//                System.out.printf("-- %s%n", student);
//        }
    }
}
