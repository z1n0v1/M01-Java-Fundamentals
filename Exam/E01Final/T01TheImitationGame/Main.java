/*
    https://judge.softuni.org/Contests/Practice/Index/2525#0

    01. The Imitation Game

You are a mathematician during world war 2, who has joined the cryptography team to decipher the enemy's enigma code.
Your job is to create a program to crack the codes.
On the first line of the input you will receive the encrypted message.
After that, until the "Decode" command is given, you will be receiving strings with instructions
for different operations that need to be performed upon the concealed message to interpret it and reveal its true content.
There are several types of instructions, split by '|'
•	Move {number of letters}
o	Moves the first n letters to the back of the string.
•	Insert {index} {value}
o	Inserts the given value before the given index in the string.
•	ChangeAll {substring} {replacement}
o	Changes all occurrences of the given substring with the replacement text.

Input / Constraints
•	On the first line, you will receive a string with message.
•	On the next lines, you will be receiving commands, split by '|' .

Output
•	After the "Decode" command is received, print this message:
"The decrypted message is: {message}"
 */

package Exam.E01Final.T01TheImitationGame;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while ((!input.equals("Decode"))) {
            String[] data = input.split("\\|");
            switch (data[0]) {
                case "Move": {

                    int n = Integer.parseInt(data[1]);
                    String temp = encryptedMessage.substring(0, n);
                    encryptedMessage.delete(0, n);
                    encryptedMessage.append(temp);
                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt(data[1]);
                    encryptedMessage.insert(index, data[2]);
                    break;
                }
                case "ChangeAll": {

                    int index = encryptedMessage.indexOf(data[1]);
                    while (index != -1) {
                        encryptedMessage.replace(index, index + data[1].length(), data[2]);
                        index += data[1].length();
                        index = encryptedMessage.indexOf(data[1], index);
                    }

//                    encryptedMessage = new StringBuilder(encryptedMessage.toString().replaceAll(data[1], data[2]));
//                    encryptedMessage = new StringBuilder(Pattern.compile(data[1]).matcher(encryptedMessage).replaceAll(data[2]));
                    break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
