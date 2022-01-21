/*
    https://judge.softuni.org/Contests/Compete/Index/1670#0

    01. Valid Usernames

Write a program that reads user names on a single line (joined by ", ") and prints all valid usernames.
A valid username is:
•	Has length between 3 and 16 characters
•	Contains only letters, numbers, hyphens and underscores
 */

package L09TextProcessing.Exercise.T01ValidUsernames;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");

        for (String word : words) {
            if(isValid(word)) System.out.println(word);
        }
    }

    private static boolean isValid(String username) {
        if (username.length() < 3 || username.length() > 16)
            return false;
        for (int i = 0; i < username.length(); i++) {
            char character = username.charAt(i);
            if (!Character.isLetter(character)
                    && !Character.isDigit(character)
                    && (character != '-') && !(character == '_'))
                return false;
        }
        return true;

    }
}
