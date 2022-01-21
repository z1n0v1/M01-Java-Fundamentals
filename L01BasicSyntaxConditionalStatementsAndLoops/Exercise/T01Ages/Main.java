/*
    https://judge.softuni.org/Contests/Practice/Index/1226#0

    01. Ages

Write a program that determines whether based on the given age a person is: baby, child, teenager, adult, elder.
The bounders are:
•	0-2 – baby;
•	3-13 – child;
•	14-19 – teenager;
•	20-65 – adult;
•	>=66 – elder;
•	All the values are inclusive.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T01Ages;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());

        if (age <= 2) System.out.println("baby");
        else if (age <= 13) System.out.println("child");
        else if (age <= 19) System.out.println("teenager");
        else if (age <= 65) System.out.println("adult");
        else System.out.println("elder");
    }
}
