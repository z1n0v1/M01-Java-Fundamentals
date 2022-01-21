/*
    https://judge.softuni.org/Contests/Practice/Index/1247#7

    08. Magic Sum

Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.
 */

package L03Arrays.Exercise.T08MagicSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int magicNumber = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < numbers.length; index++) {
            for (int rightIndex = index + 1; rightIndex < numbers.length; rightIndex++) {
                if (numbers[index] + numbers[rightIndex] == magicNumber)
                    System.out.printf("%d %d%n",numbers[index], numbers[rightIndex]);
            }
        }
    }
}
