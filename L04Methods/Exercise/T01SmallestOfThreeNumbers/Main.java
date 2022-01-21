/*
    https://judge.softuni.org/Contests/Practice/Index/1286#0

    01. Smallest of Three Numbers

Write a method to print the smallest of three integer numbers. Use appropriate name for the method.
 */

package L04Methods.Exercise.T01SmallestOfThreeNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        smallestOfThreeNumbers(a, b, c);
    }

    private static void smallestOfThreeNumbers(int a, int b, int c) {
        if (a <= b && a <= c) System.out.println(a);
        else if (b <= a && b <= c) System.out.println(b);
        else System.out.println(c);
    }
}
