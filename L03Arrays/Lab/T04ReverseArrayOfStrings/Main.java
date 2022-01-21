/*
    https://judge.softuni.org/Contests/Practice/Index/1248#3

    04. Reverse Array of Strings

Write a program to read an array of strings, reverse it and print its elements.
The input consists of a sequence of space separated strings. Print the output on a single line (space separated).

Hints
•	Read the array of strings.
•	Exchange the first element (at index 0) with the last element (at index n-1).
•	Exchange the second element (at index 1) with the element before the last (at index n-2).
•	Continue the same way until the middle of the array is reached.
 */

package L03Arrays.Lab.T04ReverseArrayOfStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str[] = scanner.nextLine().split(" ");

        for (int i = str.length - 1; i >= 0 ; i--)
            System.out.printf("%s ",str[i]);
    }
}
