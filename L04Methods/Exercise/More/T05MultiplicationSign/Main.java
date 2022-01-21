/*
    https://judge.softuni.org/Contests/Practice/Index/1294#4

    05. Multiplication Sign

You are given a number num1, num2 and num3. Write a program that finds if num1 * num2 * num3 (the product) is negative,
positive or zero. Try to do this WITHOUT multiplying the 3 numbers.
 */

package L04Methods.Exercise.More.T05MultiplicationSign;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int result = multiply(multiply(num1,num2), num3);

        if (result > 0) System.out.println("positive");
        else if (result == 0) System.out.println("zero");
        else if (result < 0) System.out.println("negative");

    }

    private static int multiply(int a, int b) {
        return a*b;
    }
}
