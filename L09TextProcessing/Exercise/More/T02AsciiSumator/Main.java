/*
    https://judge.softuni.org/Contests/Practice/Index/1674#1

    02. Ascii Sumator

Write a program that prints a sum of all characters between two given characters (their ascii code).
On the first line you will get a character.
On the second line you get another character. On the last line you get a random string.
Find all the characters between the two given and print their ascii sum.
 */

package L09TextProcessing.Exercise.More.T02AsciiSumator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstCharacter = scanner.nextLine().charAt(0);
        char secondCharacter = scanner.nextLine().charAt(0);
        String string = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > firstCharacter && string.charAt(i) < secondCharacter)
                sum += string.charAt(i);
        }
        System.out.println(sum);

    }

}
