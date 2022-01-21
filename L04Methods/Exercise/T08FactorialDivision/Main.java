/*
    https://judge.softuni.org/Contests/Practice/Index/1286#7

    08. Factorial Division

Read two integer numbers. Calculate factorial of each number.
Divide the first result by the second and print the division formatted to the second decimal point.
 */

package L04Methods.Exercise.T08FactorialDivision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f",
                1.0*calculateFactorial(a)/calculateFactorial(b));
    }

    private static double calculateFactorial(double num) {
        double factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
