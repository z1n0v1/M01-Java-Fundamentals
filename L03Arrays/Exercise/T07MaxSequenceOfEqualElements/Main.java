/*
    https://judge.softuni.org/Contests/Practice/Index/1247#6

    07. Max Sequence of Equal Elements

Write a program that finds the longest sequence of equal elements in an array of integers.
If several longest sequences exist, print the leftmost one.
 */

package L03Arrays.Exercise.T07MaxSequenceOfEqualElements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int maxSequence = 1, currentSequence = 1, maxSequenceNumber = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                currentSequence++;
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                    maxSequenceNumber = numbers[i];
                }
            } else currentSequence = 1;
        }
        for (int i = 0; i < maxSequence; i++) {
            System.out.print(maxSequenceNumber + " ");
        }
    }
}
