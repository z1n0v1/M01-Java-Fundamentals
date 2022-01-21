/*
    https://judge.softuni.org/Contests/Practice/Index/1674#3

    04. Morse Code Translator

Write a program that translates messages from Morse code to English (capital letters).
Use this page - https://morsecode.world/international/morse2.html - to help you (without the numbers).
The words will be separated by a space (' '). There will be a '|' character which you should replace with ' ' (space).
 */

package L09TextProcessing.Exercise.More.T04MorseCodeTranslator;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Character> morseCode;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeMorseCode();
        // Decode to words
        String[] words = scanner.nextLine().split(" | ");

        for (String word : words) {
            if(word.equals("|"))
                System.out.print(" ");
            else if (word.length() > 0) System.out.print(decodeWord(word));
        }


    }

    private static String decodeWord(String word) {
        String[] letters = word.split(" ");
        StringBuilder decodedWord = new StringBuilder();

        for (String letter : letters) {
            decodedWord.append(morseCode.get(letter));
        }
        return decodedWord.toString();
    }

    private static void initializeMorseCode() {
        morseCode = new HashMap<>();
        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');
//        );
    }
}
