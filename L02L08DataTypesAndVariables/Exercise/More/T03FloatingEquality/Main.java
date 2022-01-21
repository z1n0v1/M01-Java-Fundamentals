/*
    https://judge.softuni.org/Contests/Practice/Index/1270#2

    03. Floating Equality

Write a program that safely compares floating-point numbers (double) with precision eps = 0.000001.
Note that we cannot directly compare two floating-point numbers a and b by a==b
because of the nature of the floating-point arithmetic.
Therefore, we assume two numbers are equal if they are more closely to each other than some fixed constant eps.
You will receive two lines, each containing a floating-point number. Your task is to compare the values of the two numbers.

 */

package L02L08DataTypesAndVariables.Exercise.More.T03FloatingEquality;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());

        if ( Math.abs(n1-n2) < 0.000001) System.out.println("True");
        else System.out.println("False");
    }
}
