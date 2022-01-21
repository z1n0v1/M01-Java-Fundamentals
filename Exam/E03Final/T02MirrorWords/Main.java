package Exam.E03Final.T02MirrorWords;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matcher words = Pattern.compile("([#@])(?<w1>[a-zA-Z]{3,})\\1\\1(?<w2>[a-zA-Z]{3,})\\1").matcher(scanner.nextLine());
//        LinkedHashMap<String, String> pairs = new LinkedHashMap<>();
        List<String> pairs = new ArrayList<>();
        int numPairs = 0;

        while (words.find()) {
            numPairs++;
            String firstWord = words.group("w1");
            String secondWord = words.group("w2");
            if (firstWord.equals((new StringBuilder(secondWord).reverse()).toString())) {
//                pairs.put(firstWord, secondWord);
                pairs.add(firstWord);
            }
        }

        if (numPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", numPairs);
        }

        if(pairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < pairs.size() - 1; i++) {
                System.out.printf("%s <=> %s, ", pairs.get(i),
                        new StringBuilder(pairs.get(i)).reverse());
            }
            System.out.printf("%s <=> %s", pairs.get(pairs.size() - 1),
                    new StringBuilder(pairs.get(pairs.size() - 1)).reverse());
        }
    }
}
