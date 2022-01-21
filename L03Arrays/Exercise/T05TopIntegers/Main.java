/*
    https://judge.softuni.org/Contests/Practice/Index/1247#4

    05. Top Integers

Write a program to find all the top integers in an array.
A top integer is an integer which is bigger than all the elements to its right.
 */

package L03Arrays.Exercise.T05TopIntegers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < array.length; i++) {
            boolean isTrue = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] >= array[i]) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) System.out.print(array[i] + " ");
        }
    }
}
