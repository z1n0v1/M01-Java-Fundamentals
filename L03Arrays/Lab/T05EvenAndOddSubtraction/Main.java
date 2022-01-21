/*
    https://judge.softuni.org/Contests/Practice/Index/1248#4

    05. Even and Odd Subtraction

Write a program that calculates the difference between the sum of the even and the sum of the odd numbers in an array.
 */

package L03Arrays.Lab.T05EvenAndOddSubtraction;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elements = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int sumEven = 0, sumOdd = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] % 2 == 0)
                sumEven += elements[i];
            else sumOdd += elements[i];
        }
        System.out.println(sumEven - sumOdd);
    }
}
