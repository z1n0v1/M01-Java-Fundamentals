/*
    https://judge.softuni.org/Contests/Practice/Index/1270#4

    05. Decrypting Message

You will receive a key (integer) and n characters afterward. Add the key to each of the characters and append them to message.
At the end print the message, which you decrypted.

Input
•	On the first line, you will receive the key
•	On the second line, you will receive n – the number of lines, which will follow
•	On the next n lines – you will receive lower and uppercase characters from the Latin alphabet

Output
Print the decrypted message.

Constraints
•	The key will be in the interval [0…20]
•	n will be in the interval [1…20]
•	The characters will always be upper or lower-case letters from the English alphabet
•	You will receive one letter per line

 */

package L02L08DataTypesAndVariables.Exercise.More.T05DecryptingMessage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numLines = Integer.parseInt(scanner.nextLine());

        String message = "";

        for (int character = 0; character < numLines; character++) {
            char encodedChar = scanner.nextLine().charAt(0);
            message += ((char)(encodedChar+key));
        }
        System.out.println(message);
    }
}
