/*
    https://judge.softuni.org/Contests/Practice/Index/1669#4

    05. Digits, Letters and Other

Write a program that receives a single string and on the first line prints all the digits, on the second – all the letters,
and on the third – all the other characters. There will always be at least one digit, one letter and one other characters.
 */

package L09TextProcessing.Lab.T05DigitsLettersAndOther;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine()),
            numbers = new StringBuilder(), letters = new StringBuilder(), other = new StringBuilder();
//        String string = scanner.nextLine(), numbers, letters, other;

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (Character.isDigit(letter))
                numbers.append(letter);
            else if(Character.isLetter(letter))
                letters.append(letter);
            else other.append(letter);
        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(other);
    }
}
