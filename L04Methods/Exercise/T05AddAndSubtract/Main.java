/*
    https://judge.softuni.org/Contests/Practice/Index/1286#4

    05. Add and Subtract

You will receive 3 integers. Write a method sum to get the sum of the first two integers
and subtract method that subtracts the third integer from the result from the sum method.
 */

package L04Methods.Exercise.T05AddAndSubtract;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(add(a,b), c));

    }

    private static int add(int a, int b) {
        return a+b;
    }

    private static int subtract(int a, int b) {
        return a-b;
    }
}
