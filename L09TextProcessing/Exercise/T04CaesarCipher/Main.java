/*
    https://judge.softuni.org/Contests/Compete/Index/1670#3

    04. Caesar Cipher

Write a program that returns an encrypted version of the same text.
Encrypt the text by shifting each character with three positions forward.
For example A would be replaced by D, B would become E, and so on. Print the encrypted text.
 */

package L09TextProcessing.Exercise.T04CaesarCipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String unencryptedMessage = scanner.nextLine();

        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < unencryptedMessage.length(); i++) {
            encryptedMessage.append(((char) (unencryptedMessage.charAt(i) + 3)));
        }
        System.out.println(encryptedMessage.toString());
    }
}
