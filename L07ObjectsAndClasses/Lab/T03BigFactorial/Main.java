/*
    https://judge.softuni.org/Contests/Practice/Index/1319#2

    03. Big Factorial

You will receive N - number in range [0 - 1000]. Calculate Factorial of N and print the result.
 */

package L07ObjectsAndClasses.Lab.T03BigFactorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
