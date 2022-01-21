/*
    https://judge.softuni.org/Contests/Practice/Index/1312#0

    01. Count Chars in a String

Write a program, which counts all characters in a string except space (' ').
Print all occurrences in the following format:
{char} -> {occurrences}
 */

package L08AssociativeArrays.Exercise.T01CountCharsInString;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();

        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character != ' ') {
                if (counts.containsKey(character)) {
                    counts.put(character, counts.get(character) + 1);
                } else {
                    counts.put(character, 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
