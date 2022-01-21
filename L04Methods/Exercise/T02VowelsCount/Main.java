/*
    https://judge.softuni.org/Contests/Practice/Index/1286#1

    02. Vowels Count

Write a method that receives a single string and prints the count of the vowels. Use appropriate name for the method.
 */

package L04Methods.Exercise.T02VowelsCount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        countVowels(scanner.nextLine());
    }

    private static void countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (
                    str.charAt(i) == 'a'
                            || str.charAt(i) == 'A'
                            || str.charAt(i) == 'e'
                            || str.charAt(i) == 'E'
                            || str.charAt(i) == 'i'
                            || str.charAt(i) == 'I'
                            || str.charAt(i) == 'o'
                            || str.charAt(i) == 'O'
                            || str.charAt(i) == 'u'
                            || str.charAt(i) == 'U'
            ) count++;
        }
        System.out.println(count);
    }
}
