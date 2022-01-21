/*
    https://judge.softuni.org/Contests/Practice/Index/1669#1

    02. Repeat Strings

Write a Program That Reads an Array of Strings. Each String is Repeated N Times, Where N is the Length of the String.
Print the Concatenated String.
 */

package L09TextProcessing.Lab.T02RepeatStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        for (String word : words) {
            System.out.printf("%s", repeat(word));
        }

    }

    private static String repeat(String word) {
        StringBuilder repeatWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            repeatWord.append(word);
        }
        return repeatWord.toString();
    }
}
