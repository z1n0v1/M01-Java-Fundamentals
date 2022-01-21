/*
    https://judge.softuni.org/Contests/Practice/Index/1279#0

    01. Encrypt, Sort and Print Array

Write a program that reads a sequence of strings from the console. Encrypt every string by summing:
•	The code of each vowel multiplied by the string length
•	The code of each consonant divided by the string length
Sort the number sequence in ascending order and print it on the console.
On first line, you will always receive the number of strings you have to read.
 */

package L03Arrays.Exercise.More.T01EncryptSortAndPrintArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNames = Integer.parseInt(scanner.nextLine());
        int[] encodedNames = new int[numNames];

        for (int i = 0; i < numNames; i++) {
            String name = scanner.nextLine();
            encodedNames[i] = encodeName(name);
        }

        Arrays.sort(encodedNames);
        for (int encodedName : encodedNames) {
            System.out.println(encodedName);
        }

    }

    private static int encodeName(String name) {
        int encodedName = 0;
        for (int i = 0; i < name.length(); i++) {
            char character = name.charAt(i);
            if (isVowel(character))
                encodedName += character * name.length();
            else encodedName += character / name.length();
        }

        return encodedName;
    }

    private static boolean isVowel(char character) {
        return (
                (character == 'a')
                        || (character == 'A')
                        || (character == 'e')
                        || (character == 'E')
                        || (character == 'i')
                        || (character == 'I')
                        || (character == 'o')
                        || (character == 'O')
                        || (character == 'u')
                        || (character == 'U')
        );
    }
}
