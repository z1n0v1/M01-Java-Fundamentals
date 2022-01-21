/*
    https://judge.softuni.org/Contests/Practice/Index/1190#2

    03. Passed or Failed

 Write a program, which takes as an input a grade and prints "Passed!" if the grade is equal or more than 3.00.
 Modify the above program, so it will print "Failed!" if the grade is lower than 3.00.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T03PassedOrFailed;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 3)
            System.out.println("Passed!");
        else System.out.println("Failed!");
    }
}
