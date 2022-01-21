/*
    https://judge.softuni.org/Contests/Compete/Index/1670#1

    02. Character Multiplier

Create a method that takes two strings as arguments and returns the sum of their character codes
multiplied (multiply str1[0] with str2[0] and add to the total sum).
Then continue with the next two characters.
If one of the strings is longer than the other, add the remaining character codes to the total sum without multiplication.
 */

package L09TextProcessing.Exercise.T02CharacterMultiplier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] str = scanner.nextLine().split("\\s+");

        System.out.println(getCharacterSum(str[0], str[1]));

    }

    private static int getCharacterSum(String str1, String str2) {
        int sum = 0;

        if (str2.length()> str1.length()) { //str1 will be always longer
            String str = str2;
            str2 = str1;
            str1 = str;
        } //str1 will be always longer

        for (int i = 0; i < str2.length(); i++) {
            sum += str1.charAt(i) * str2.charAt(i);
        }
        for (int i = str2.length(); i < str1.length(); i++) {
            sum += str1.charAt(i);
        }
        return sum;
    }
}
