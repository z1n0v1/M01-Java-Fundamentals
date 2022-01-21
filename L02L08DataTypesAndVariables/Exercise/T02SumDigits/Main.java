/*
    https://judge.softuni.org/Contests/Practice/Index/1228#1

    02. Sum Digits

You will be given a single integer. Your task is to find the sum of its digits.
 */

package L02L08DataTypesAndVariables.Exercise.T02SumDigits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println(sum);
    }
}
