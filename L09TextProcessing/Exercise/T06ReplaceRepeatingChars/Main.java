/*
    https://judge.softuni.org/Contests/Compete/Index/1670#5

    06. Replace Repeating Chars

Write a program that reads a string from the console and
replaces any sequence of the same letters with a single corresponding letter
 */

package L09TextProcessing.Exercise.T06ReplaceRepeatingChars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                string.deleteCharAt(i+1);
                i--;
            }
        }
        System.out.println(string);
    }
}
