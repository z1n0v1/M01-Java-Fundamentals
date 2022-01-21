/*
    https://judge.softuni.org/Contests/Practice/Index/2474#0

    01. SoftUni Reception

Every day thousands of students pass by the reception at SoftUni with different questions to ask and the employees
have to help everyone by providing all the information and to answer all of the questions.
There are 3 employees working on the reception all day. Each of them can handle different number of students per hour.
Your task is to calculate how much time it will take to answer all the questions of given number of students.
First you will receive 3 lines with integers, representing count of students that each of the employee can help per hour.
On the next line you will receive students count as a single integer.
Every forth hour all of the employees have a break, so they don’t work for a hour.
This is the only break for the employees, because they don`t need rest, nor have a personal life.
Calculate the time needed to answer all the student's questions and print it in the following format: "Time needed: {time}h."

Input / Constraints
•	On first three lines -  each employee efficiency -  integer in range [1 - 100]
•	On the fourth line - students count – integer in range [0 – 10000]
•	Input will always be valid and in the range specified

Output
•	Print a single line: "Time needed: {time}h."
•	Allowed working time / memory: 100ms / 16MB
 */

package Exam.E02MidExam.T01SoftUniReception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;
        int neededHours = 0;
        int workHours = 0;

//        neededHours = (int) Math.ceil(1.0*students/studentsPerHour);
//        neededHours += neededHours/3;

        while (true) {
            if(students<=0) break; // 0 studs - no time
            students-=studentsPerHour;
            neededHours++; workHours++;
            if(students<=0) break;
            if(workHours%3==0) neededHours++;
        }




        System.out.printf("Time needed: %dh.%n",neededHours);

    }
}
