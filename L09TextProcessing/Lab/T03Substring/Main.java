/*
    https://judge.softuni.org/Contests/Practice/Index/1669#2

    03. Substring

On the first line you will receive a string. On the second line you will receive a second string.
Write a program that removes all of the occurrences of the first string in the second until there is no match.
At the end print the remaining string.
 */

package L09TextProcessing.Lab.T03Substring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        while (secondString.contains(firstString)) {
            secondString = secondString.replace(firstString, "");
        }
        System.out.println(secondString);

    }
}
