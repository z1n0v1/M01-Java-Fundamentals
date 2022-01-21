/*
    https://judge.softuni.org/Contests/Practice/Index/1260#9

    10. Multiply Evens by Odds

Create a program that reads an integer number and multiplies the sum of all its even digits by the sum of all its odd digits.
 */

package L04Methods.Lab.T10MultiplyEvensByOdds;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                getMultipleOfEvensAndOdds(
                        Math.abs(
                                Integer.parseInt(
                                        scanner.nextLine()
                                )
                        )
                )
        );
    }

    private static int getMultipleOfEvensAndOdds (int num) {
        return getEvenDigitsSum(num) * getOddDigitsSum(num);
    }

    private static int getEvenDigitsSum (int num) {
        int evenSum = 0;

        while (num>0) {
            int digit = num % 10;
            num /= 10;
            if (digit % 2 == 0)
                evenSum += digit;
        }
        return evenSum;
    }

    private static int getOddDigitsSum (int num) {
        int oddSum = 0;

        while (num>0) {
            int digit = num % 10;
            num /= 10;
            if (digit % 2 == 1)
                oddSum += digit;
        }
        return oddSum;
    }
}
