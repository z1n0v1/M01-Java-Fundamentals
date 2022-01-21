/*
    https://judge.softuni.org/Contests/Practice/Index/1674#2

    03. Treasure Finder

Write a program that decrypts a message by a given key and gathers information about hidden treasure type and its coordinates.
On the first line you will receive a key (sequence of numbers).
On the next few lines until you receive "find" you will get lines of strings.
You have to loop through every string and decrease the ascii code of each character
with a corresponding number of the key sequence.
The way you choose a key number from the sequence is just looping through it.
If the length of the key sequence is less than the string sequence, you start looping from the beginning of the key.
For more clarification see the example below.
After decrypting the message you will get a type of treasure and its coordinates.
The type will be between the symbol '&' and the coordinates will be between the symbols '<' and '>'.
For each line print the type and the coordinates in format "Found {type} at {coordinates}".
 */

package L09TextProcessing.Exercise.More.T03TreasureFinder;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String encryptedString = scanner.nextLine();

        while (!encryptedString.equals("find")) {
            decryptAndPrint(encryptedString, key);
            encryptedString = scanner.nextLine();
        }
    }

    private static void decryptAndPrint(String encryptedString, int[] key) {
        StringBuilder decryptedString = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < encryptedString.length(); i++) {
            decryptedString.append(((char) (encryptedString.charAt(i) - key[keyIndex])));
            keyIndex++;
            if (keyIndex == key.length) keyIndex = 0;
        }
        String[] data = decryptedString.toString().split("[ & < >]+");
        System.out.printf("Found %s at %s%n", data[1], data[3]);
    }
}
