/*
    https://judge.softuni.org/Contests/Practice/Index/1260#1

    02. Grades

Write a method that receives a grade between 2.00 and 6.00 and prints the corresponding grade in words:
•	2.00 – 2.99 - "Fail"
•	3.00 – 3.49 - "Poor"
•	3.50 – 4.49 - "Good"
•	4.50 – 5.49 - "Very good"
•	5.50 – 6.00 - "Excellent"

 */

package L04Methods.Lab.T02Grades;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printGrade(Double.parseDouble(scanner.nextLine()));

    }

    private static void printGrade(double mark) {
        if (mark < 3)
            System.out.println("Fail");
        else if (mark < 3.5)
            System.out.println("Poor");
        else if (mark < 4.5)
            System.out.println("Good");
        else if (mark < 5.5)
            System.out.println("Very good");
        else System.out.println("Excellent");
    }
}
