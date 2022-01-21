/*
    https://judge.softuni.org/Contests/Practice/Index/1319#0

    01. Randomize Words

You are given a list of words on one line. Randomize their order and print each word on a separate line.

Hints
•	Split the input string (by space) and create an array of words.
•	Create a random number generator - an object rnd of type Random.
•	In a for-loop exchange each number at positions 0, 1, …, words.Length-1 by a number at random position.
    To generate a random number in range use rnd.nextInt(words.length).
•	Print each word in the array on new line.
 */

package L07ObjectsAndClasses.Lab.T01RandomizeWords;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int randomIndex = rnd.nextInt(words.length);
            String tempWord = words[randomIndex];
            words[randomIndex] = words[i];
            words[i] = tempWord;
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
