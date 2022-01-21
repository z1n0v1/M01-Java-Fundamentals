/*
    https://judge.softuni.org/Contests/Practice/Index/1226#7

    08. Triangle of Numbers

Write a program, which receives a number – n, and prints a triangle from 1 to n as in the examples.
Constraints
•	n will be in the interval [1...20].

In      Out
3	    1
        2 2
        3 3 3
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T08TriangleOfNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {

                System.out.printf("%d ",i);

            }
            System.out.println();

        }
    }
}
