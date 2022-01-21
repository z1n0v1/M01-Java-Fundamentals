/*
    5.	* Odd Times

You are given an array of positive integers in a single line, separated by a space (' ').
All numbers occur even number of times except one number which occurs odd number of times. Find it, using only bitwise operations.

Hints
1.	Read an array of integers.
2.	Initialize a variable result with value 0.
3.	Iterate through all number in the array.
4.	Use XOR (^) of result and all numbers in the array.
a.	XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x
5.	Print the result.

Think why the above algorithms is correct.
 */

package L06BitwiseOperations.Lab.T05OddTimes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int result = 0;

        for (int number : numbers)
            result = result ^ number;
        System.out.println(result);
    }
}
