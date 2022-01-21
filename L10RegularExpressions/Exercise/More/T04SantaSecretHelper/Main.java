/*
    https://judge.softuni.org/Contests/Practice/Index/1758#3

    4. Santa's Secret Helper

After the successful second Christmas, Santa needs to gather information about the behavior of children
to plan the presents for next Christmas. He has a secret helper, who is sending him encrypted information.
Your task is to decrypt it and create a list of the children who have been good.
You will receive an integer, which represents a key and afterwards some messages,
which you must decode by subtracting the key from the value of each character.
After the decryption, to be considered a valid match, a message should:
-	Have a name, which starts after '@' and contains only letters from the Latin alphabet
-	Have a behaviour type - "G"(good) or "N"(naughty) and must be surrounded by "!" (exclamation mark).
The order in the message should be: child’s name -> child’s behavior.
They can be separated from the others by any character except: '@', '-', '!', ':' and '>'.
You will be receiving message until you are given the “end” command.
Afterwards, print the names of the children, who will receive a present, each on a new line.

Input / Constraints
•	The first line holds n – the number which you have to subtract from the characters – integer in range [1…100];
•	On the next lines, you will be receiving encrypted messages.

Output
Print the names of the children, each on a new line
 */

package L10RegularExpressions.Exercise.More.T04SantaSecretHelper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("@(?<name>[a-zA-Z]+)[^@\\-!:\\>]+!(?<type>[GN])!");

        int key = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();;

        while (!input.equals("end")) {
            Matcher kid = pattern.matcher(decode(input, key));
            if(kid.find() && kid.group("type").equals("G"))
                System.out.println(kid.group("name"));
            input = scanner.nextLine();
        }
    }

    private static String decode(String encryptedMessage, int key) {
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            decodedString.append((char) (encryptedMessage.charAt(i) - key));
        }
        return decodedString.toString();
    }
}
