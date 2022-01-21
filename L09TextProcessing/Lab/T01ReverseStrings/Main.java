/*
    https://judge.softuni.org/Contests/Practice/Index/1669#0

    01. Reverse Strings

You will be given series of strings until you receive an "end" command.
 Write a program that reverses strings and printseach pair on separate line in format "{word} = {reversed word}".
 */

package L09TextProcessing.Lab.T01ReverseStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            words.add(input);
            input = scanner.nextLine();
        }

        for ( String word : words)
            System.out.printf("%s = %s%n",word, reverseWord(word));
    }

    private static String reverseWord(String word) {
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        return reversedWord;
    }
}
