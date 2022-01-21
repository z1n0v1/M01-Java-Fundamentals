/*
    https://judge.softuni.org/Contests/Practice/Index/1758#2

    3. Post Office

You read a single line of ASCII symbols, and the message is somewhere inside it, you must find it.
 The input consists of three parts separated with "|" like this:
"{firstPart}|{secondPart}|{thirdPart}"
Each word starts with capital letter and has a fixed length, you can find those in each different part of the input.
The first part carries the capital letters for each word inside the message.
You need to find those capital letters 1 or more from A to Z.
The capital letters should be surrounded from the both sides with any of the following symbols – "#, $, %, *, &".
And those symbols should match on the both sides. This means that $AOTP$ - is a valid pattern for the capital letters.
$AKTP% - is invalid since the symbols do not match.
The second part of the data contains the starting letter ASCII code and words length /between 1 – 20 charactes/,
in the following format: "{asciiCode}:{length}". For example, "67:05" – means that '67' - ascii code
equal to the capital letter "C", represents a word starting with "C" with following 5 characters: like "Carrot".
The ascii code should be a capital letter equal to a letter from the first part. Word's length should be exactly 2 digits.
Length less than 10 will always have a padding zero, you don't need to check that.
The third part of the message are words separated by spaces.
Those words have to start with Capital letter [A…Z] equal to the ascii code and have exactly the length for each capital letter
you have found in the second part. Those words can contain any ASCII symbol without spaces.
When you find valid word, you have to print it on a new line.

Input / Constraints
•	On the first line – the text in form of three different parts separated by "|".
There can be any ASCII character inside the input, except '|'.
•	Input will always be valid - you don’t need to check it
•	The input will always have three different parts, that will always be separated by "|".

Output
•	Print all extracted words, each on a new line.
•	Allowed working time / memory: 100ms / 16MB
 */

package L10RegularExpressions.Exercise.More.T03PostOffice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Бъга е в това, че принтира думите в реда в който са в стринга, а не в реда в който са подредени главните букви

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s*\\|\\s*");
        Matcher uppercaseSymbols = Pattern.compile("([#$\\*&])(?<sym>[A-Z]+)\\1").matcher(data[0]);
        Matcher wordInfo = Pattern.compile("(?<ascii>[0-9]+):(?<length>[0-9]{2})").matcher(data[1]);
        String[] words = data[2].split("\\s+");

        LinkedHashMap<Character, Integer> approvedWords = new LinkedHashMap<>();

        String wordsBeginWith = "";
        while (uppercaseSymbols.find()) wordsBeginWith = uppercaseSymbols.group("sym");
        while (wordInfo.find()) {
            char firstSymbol = (char) Integer.parseInt(wordInfo.group("ascii"));
            if (wordsBeginWith.contains("" + firstSymbol)) {
                int length = Integer.parseInt(wordInfo.group("length")) + 1;  // First character with following N characters
                if (length >= 1 && length <= 20)
                    approvedWords.put(firstSymbol, length);
            }
        }
        for (String word : words) {
            if (approvedWords.containsKey(word.charAt(0))) {
                if (word.length() == approvedWords.get(word.charAt(0))) {
                    System.out.println(word);
                }
            }
        }
    }
}
