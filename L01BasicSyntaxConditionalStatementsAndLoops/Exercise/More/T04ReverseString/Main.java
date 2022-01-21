/*
    https://judge.softuni.org/Contests/Practice/Index/1461#3

    04. Reverse String

Write a program which reverses a string and print it on the console.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.More.T04ReverseString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine());
        System.out.println(string.reverse());
    }
}
