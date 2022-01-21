/*
    https://judge.softuni.org/Contests/Practice/Index/1319#1

    02. Sum Big Numbers

You will receive two numbers (0 to 10^50), print their sum.

 */

package L07ObjectsAndClasses.Lab.T02SumBigNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = new BigInteger(scanner.nextLine());
        BigInteger b = new BigInteger(scanner.nextLine());

        System.out.println(a.add(b));
    }
}
