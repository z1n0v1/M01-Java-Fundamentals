/*
    https://judge.softuni.org/Contests/Practice/Index/1669#3

    04. Text Filter

Write a program that takes a text and a string of banned words.
All words included in the ban list should be replaced with asterisks "*", equal to the word's length.
The entries in the ban list will be separated by a comma and space ", ".
The ban list should be entered on the first input line and the text on the second input line.
 */

package L09TextProcessing.Lab.T04TextFilter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");

        String sentence = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            StringBuilder asterisks = new StringBuilder();

            for (int i = 0; i < bannedWord.length(); i++) {
                asterisks.append("*");
            }

            while (sentence.contains(bannedWord)) {
                sentence = sentence.replace(bannedWord, asterisks.toString());
            }
        }
        System.out.println(sentence);
    }
}
