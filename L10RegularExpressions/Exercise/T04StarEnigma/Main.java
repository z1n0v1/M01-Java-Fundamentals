/*
    https://judge.softuni.org/Contests/Compete/Index/1673#3

    04. Star Enigma

The war is in its peak, but you, young Padawan, can turn the tides with your programming skills.
You are tasked to create a program to decrypt the messages of The Order and prevent the death of hundreds of lives.
You will receive several messages, which are encrypted using the legendary star enigma.
You should decrypt the messages, following these rules:
To properly decrypt a message, you should count all the letters [s, t, a, r] – case insensitive
and remove the count from the current ASCII value of each symbol of the encrypted message.

After decryption:
Each message should have a planet name, population, attack type ('A', as attack or 'D', as destruction) and soldier count.
The planet name starts after '@' and contains only letters from the Latin alphabet.
The planet population starts after ':' and is an Integer;
The attack type may be "A"(attack) or "D"(destruction) and must be surrounded by "!" (exclamation mark).
The soldier count starts after "->" and should be an Integer.
The order in the message should be: planet name -> planet population -> attack type -> soldier count.
Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.

Input / Constraints
•	The first line holds n – the number of messages– integer in range [1…100];
•	On the next n lines, you will be receiving encrypted messages.

Output
After decrypting all messages, you should print the decrypted information in the following format:
First print the attacked planets, then the destroyed planets.
"Attacked planets: {attackedPlanetsCount}"
"-> {planetName}"
"Destroyed planets: {destroyedPlanetsCount}"
"-> {planetName}"
The planets should be ordered by name alphabetically.

 */

package L10RegularExpressions.Exercise.T04StarEnigma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>(),
                destroyedPlanets = new ArrayList<>();
        String regex = "@(?<name>[a-zA-Z]+)[^@\\-\\!:\\>]*:(?<population>[0-9]+)[^@\\-\\!:\\>]*\\!(?<type>[AD])\\![^@\\-\\!:\\>]*\\-\\>(?<soldiers>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String message = decrypt(scanner.nextLine());

            Matcher messageMatcher = pattern.matcher(message);

            if (messageMatcher.find()) {
                if(messageMatcher.group("type").charAt(0) == 'D') {
                    destroyedPlanets.add(messageMatcher.group("name"));
                } else {
                    attackedPlanets.add(messageMatcher.group("name"));
                }
            }
        }
        System.out.printf("Attacked planets: %d%n",attackedPlanets.size());
        attackedPlanets.stream().sorted().forEach(planet -> System.out.printf("-> %s%n", planet));
        System.out.printf("Destroyed planets: %d%n",destroyedPlanets.size());
        destroyedPlanets.stream().sorted().forEach(planet -> System.out.printf("-> %s%n", planet));

    }

    private static String decrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder(message);
        StringBuilder decryptedMessage = new StringBuilder();

        int key = 0;
        // should count all the letters [s, t, a, r] – case insensitive
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char character = encryptedMessage.charAt(i);
            if (character == 's' || character == 'S' 
                    || character == 't' || character == 'T'
                    || character == 'a' || character == 'A'
                    || character == 'r' || character == 'R') {
                key++;

            }
        }
        for (int i = 0; i < encryptedMessage.length(); i++) {
            decryptedMessage.append((char) (encryptedMessage.charAt(i) - key));
        }
        return decryptedMessage.toString();
    }
}
