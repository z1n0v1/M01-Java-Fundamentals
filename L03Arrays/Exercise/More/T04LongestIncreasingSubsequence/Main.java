/*
Fundamentals -> 12 - More Exercise - Arrays -> 04. Longest Increasing Subsequence
https://judge.softuni.org/Contests/Practice/Index/1279#3

Read a list of integers and find the longest increasing subsequence (LIS). If several such exist, print the leftmost.

Hints
•	Assume we have n numbers in an array nums[0…n-1].
•	Let len[p] holds the length of the longest increasing subsequence (LIS) ending at position p.
•	In a for loop, we shall calculate len[p] for p = 0 … n-1 as follows:
o	Let left is the leftmost position on the left of p (left < p), such that len[left] is the largest possible.
o	Then, len[p] = 1 + len[left]. If left does not exist, len[p] = 1.
o	Also, save prev[p] = left (we hold if prev[] the previous position, used to obtain the best length for position p).
•	Once the values for len[0…n-1] are calculated, restore the LIS starting from position p such that len[p]
    is maximal and go back and back through p = prev[p].

https://www.youtube.com/watch?v=fV-TF4OvZpk - Find The Longest Increasing Subsequence - Dynamic Programming Fundamentals
 */
package L03Arrays.Exercise.More.T04LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        int[] nums = Arrays
//                .stream("3 14 5 12 15 7 8 9 11 10 1".split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        int[] nums = Arrays
//                .stream("7 3 5 8 -1 0 6 7".split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        int length = nums.length;
        int len[] = new int[length];
        int prev[] = new int[length];

        len[0] = 1;
        prev[0] = -1;
        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && len[i] <= len[j]) {
                    prev[i] = j;
                    len[i] = len[j] + 1;
                    if (len[i] > len[maxIndex])
                        maxIndex = i;
                }
            }
            if(len[i] == 0) len[i] = 1;
        }

        int lenAnswer = len[maxIndex];
        int [] answer = new int[lenAnswer];

        int leftIndex = prev[maxIndex];

        answer[lenAnswer-1] = nums[maxIndex];
        for (int index = lenAnswer-2; index >=0 ; index--) {
            if(leftIndex>-1) {
                answer[index] = nums[leftIndex];
                leftIndex = prev[leftIndex];
            }
        }
        for (int element: answer)
            System.out.print(element + " ");
        System.out.println();

//        System.out.println("Nums:   " + Arrays.toString(nums));
//        System.out.println("Len:    " + Arrays.toString(len));
//        System.out.println("Prev:   " + Arrays.toString(prev));
//        System.out.println(maxIndex);
    }
}
