package L10RegularExpressions.Exercise.More.T03T2PostOffice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s*\\|\\s*");
        Matcher uppercaseSymbols = Pattern.compile("([#$*&])(?<sym>[A-Z]+)\\1").matcher(data[0]);
        Matcher wordInfo = Pattern.compile("(?<ascii>[0-9]+):(?<length>[0-9]{2})").matcher(data[1]);
        String[] words = data[2].split("\\s+");

        LinkedHashMap<Character, Integer> approvedWords = new LinkedHashMap<>();

        String wordsBeginWith = "";
        while (uppercaseSymbols.find())
            wordsBeginWith = uppercaseSymbols.group("sym");

        // обхождам ключовите букви и ги запазвам в мапа, за да запазим техния ред
        for (int i = 0; i < wordsBeginWith.length(); i++) {
            approvedWords.put(wordsBeginWith.charAt(i), 0);
        }

        while (wordInfo.find()) {
            char firstSymbol = (char) Integer.parseInt(wordInfo.group("ascii"));
            if (wordsBeginWith.contains("" + firstSymbol)) {
                int length = Integer.parseInt(wordInfo.group("length"))
                        + 1;  // First character with following N characters
                if (length >= 1 && length <= 20)
                    approvedWords.put(firstSymbol, length);
            }
        }

// Филтрирам резултатите по тези ключови букви и принтирам думите в реда на ключовите думи, примерно ако първата буква е P принтирам думите, които започват с нея и отговарят на условието и т.н.
        approvedWords
                .entrySet()
                .forEach((k -> {
                    Arrays.stream(words)
                            .filter(word -> word.charAt(0) == k.getKey() && word.length() == k.getValue())
                            .forEach(System.out::println);
                }));

//        for (String word : words) {
//            if (approvedWords.containsKey(word.charAt(0))) {
//                if (word.length() == approvedWords.get(word.charAt(0))) {
//                    System.out.println(word);
//                }
//            }
//        }
//    }
    }
}