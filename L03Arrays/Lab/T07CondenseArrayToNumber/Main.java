/*
    https://judge.softuni.org/Contests/Practice/Index/1248#6

    07. Condense Array to Number

Write a program to read an array of integers and condense them by summing adjacent couples of elements
until a single integer is obtained.
For example, if we have 3 elements {2, 10, 3}, we sum the first two and the second two elements
and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.
 */

package L03Arrays.Lab.T07CondenseArrayToNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        while (nums.length > 1) {
            int[] condensed = new int[nums.length-1];

            for (int i = 0; i <= condensed.length - 1; i++) {
                condensed[i] = nums[i] + nums[i+1];
            }
            nums = condensed;
        }
        System.out.println(nums[0]);
    }
}
