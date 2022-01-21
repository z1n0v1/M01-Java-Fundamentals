/*
    https://judge.softuni.org/Contests/Practice/Index/1294#3

    04. Tribonacci Sequence

In the "Tribonacci" sequence, every number is formed by the sum of the previous 3.
You are given a number num. Write a program that prints num numbers from the Tribonacci sequence,
each on a new line, starting from 1. The input comes as a parameter named num.
The value num will always be positive integer.
 */

package L04Methods.Exercise.More.T04TribonacciSequence;

import java.util.Scanner;

public class Main {
    static int[] tribonacciNumbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        tribonacciNumbers = new int[num];

        computeTribonacci(num);

        for (int i = 0; i < tribonacciNumbers.length; i++) {
            System.out.printf("%d ", tribonacciNumbers[i]);
        }


    }

    private static void computeTribonacci(int num) {
        for (int i = 0; i < tribonacciNumbers.length; i++) {
            if (i == 0) tribonacciNumbers[i] = 1;
            else if (i == 1) tribonacciNumbers[i] = 1;
            else if (i == 2) tribonacciNumbers[i] = 2;
            else tribonacciNumbers[i] = tribonacciNumbers[i - 1] + tribonacciNumbers[i - 2] + tribonacciNumbers[i -3];
        }
    }
}
