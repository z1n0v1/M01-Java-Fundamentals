/*
    https://judge.softuni.org/Contests/Practice/Index/1226#3

    04. Print and Sum

Write a program to display numbers from given start to given end and their sum. All the numbers will be integers.
On the first line you will receive the start number, on the second the end number.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T04PrintAndSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = a; i <= b; i++) {

            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);
    }
}
