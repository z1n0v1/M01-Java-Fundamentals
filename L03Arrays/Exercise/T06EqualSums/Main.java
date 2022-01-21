/*
    https://judge.softuni.org/Contests/Practice/Index/1247#5

    06. Equal Sums

Write a program that determines if there exists an element in the array such that
the sum of the elements on its left is equal to the sum of the elements on its right.
If there are no elements to the left / right, their sum is considered to be 0.
Print the index that satisfies the required condition or “no” if there is no such index.
 */

package L03Arrays.Exercise.T06EqualSums;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        boolean exists = false;
        for (int i = 0; i < array.length; i++) {
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                exists = true;
            }
        }
        if (!exists) System.out.println("no");
    }
}
