package Exam.E00Final;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // [@#]+(?<color>[a-z]{3,})[@#]+(?![a-zA-Z])
//        (?![0-9]).
//        [@#]+(?<color>[a-z]{3,})[@#]+[^a-zA-Z0-9]*/+(?<count>[0-9]*)/*
        Matcher eggs = Pattern.compile("[@#]+(?<color>[a-z]{3,})[@#]+[^a-zA-Z0-9]*/+(?<count>[0-9]*)/+")
                .matcher(scanner.nextLine());
        while (eggs.find()) {
            System.out.printf("You found %s %s eggs!%n",eggs.group("count"), eggs.group("color"));
        }
    }
}
