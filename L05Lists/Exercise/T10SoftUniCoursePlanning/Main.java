/*
    https://judge.softuni.org/Contests/Practice/Index/1297#9

    10. SoftUni Course Planning

You are tasked to help plan the next Programing Fundamentals course by keeping track of the lessons,
that are going to be included in the course, as well as all the exercises for the lessons.
On the first input line you will receive the initial schedule of lessons and exercises
that are going to be part of the next course, separated by comma and space ", ".
But before the course starts, there are some changes to be made. Until you receive "course start"
you will be given some commands to modify the course schedule. The possible commands are:

Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
Insert:{lessonTitle}:{index} -insert the lesson to the given index, if it does not exist
Remove:{lessonTitle} -remove the lesson, if it exists
Swap:{lessonTitle}:{lessonTitle} -change the place of the two lessons, if they exist
Exercise:{lessonTitle} -add Exercise in the schedule right after the lesson index,
if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise".
If the lesson doesn't exist, add the lesson in the end of the course schedule, followed by the Exercise.

Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.

Input
•	On the first line -the initial schedule lessons -strings, separated by comma and space ", "
•	Until "course start" you will receive commands in the format described above

Output
•	Print the whole course schedule, each lesson on a new line with its number(index) in the schedule:
"{lesson index}.{lessonTitle}"
•	Allowed working time / memory: 100ms / 16MB
 */

package L05Lists.Exercise.T10SoftUniCoursePlanning;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<String> program;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        program = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] command = input.split(":");

            switch (command[0]) {
                case "Add":
                    addLesson(command[1]);
                    break;
                case "Insert":
                    insertLesson(command[1], Integer.parseInt(command[2]));
                    break;
                case "Remove":
                    removeLesson(command[1]);
                    break;
                case "Swap":
                    swapLessons(command[1], command[2]);
                    break;
                case "Exercise":
                    addExercise(command[1]);
                    break;
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < program.size(); i++) {
            System.out.printf("%d.%s%n",i + 1, program.get(i));
        }
    }

    private static void addLesson(String lessonTitle) {
        if (-1 == findLesson(lessonTitle))
            program.add(lessonTitle);
    }

    private static void insertLesson(String lessonTitle, int index) {
        if (-1 == findLesson(lessonTitle))
            program.add(index, lessonTitle);
    }

    private static void removeLesson(String lessonTitle) {
        int lessonIndex = findLesson(lessonTitle);
        if (lessonIndex >= 0) program.remove(lessonIndex);
        int exerciseIndex = findLesson(lessonTitle + "-Exercise");
        if (exerciseIndex >= 0) program.remove(exerciseIndex);
    }

    private static void swapLessons(String firstTitle, String secondTitle) {
        int firstLessonIndex = findLesson(firstTitle),
                secondLessonIndex = findLesson(secondTitle),
                firstExerciseIndex = findLesson(firstTitle + "-Exercise"),
                secondExerciseIndex = findLesson(secondTitle + "-Exercise");

        if (firstLessonIndex >= 0 && secondLessonIndex >= 0) {
            program.set(firstLessonIndex, secondTitle);
            program.set(secondLessonIndex, firstTitle);

            if (firstExerciseIndex >= 0 && secondExerciseIndex >= 0) {
                program.set(firstExerciseIndex, secondTitle + "-Exercise");
                program.set(secondExerciseIndex, firstTitle + "-Exercise");

            } else if (firstExerciseIndex >= 0) {
                program.remove(firstExerciseIndex);
                firstLessonIndex = findLesson(firstTitle); // The known indexes are invalid
                program.add(firstLessonIndex + 1, firstTitle + "-Exercise");

            } else if (secondExerciseIndex >= 0) {
                program.remove(secondExerciseIndex);
                secondLessonIndex = findLesson(secondTitle); // The known indexes are invalid
                program.add(secondLessonIndex + 1, secondTitle + "-Exercise");
            }

        }
    }

    private static void addExercise(String lessonTitle) {
        int lessonIndex = findLesson(lessonTitle),
                exerciseIndex = findLesson(lessonTitle + "-Exercise");
        if (lessonIndex >= 0 && exerciseIndex >= 0) {
            return;
        } else if (lessonIndex >= 0) {
            program.add(lessonIndex + 1, lessonTitle + "-Exercise");
        } else {
            program.add(lessonTitle);
            program.add(lessonTitle + "-Exercise");
        }
    }

    private static int findLesson(String lessonTitle) {

        return program.indexOf(lessonTitle);
    }
}
