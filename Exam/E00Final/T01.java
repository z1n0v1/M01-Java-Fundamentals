package Exam.E00Final;

import java.util.Scanner;

public class T01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Translate": {
                    String character = command[1];
                    String replacement = command[2];
                    string = new StringBuilder(string.toString().replaceAll(character, replacement));
                    System.out.println(string);
                    break;
                }
                case "Includes": {
                    String substring = command[1];
                    if (string.indexOf(substring) == -1)
                        System.out.println("False");
                    else System.out.println("True");
//                    System.out.println(string);
                    break;
                }
                case "Start": {
                    String startsWith = command[1];
                    if (string.indexOf(startsWith) == 0)
                        System.out.println("True");
                    else System.out.println("False");
                    break;
                }
                case "Lowercase": {
                    string = new StringBuilder(string.toString().toLowerCase());
                    System.out.println(string);
                    break;
                }
                case "FindIndex": {
                    String character = command[1];
                    int lastIndex = -1, currentIndex = 0;
                    currentIndex = string.indexOf(character);
                    while ( currentIndex != -1) {
                        lastIndex = currentIndex;
                        currentIndex = string.indexOf(character, lastIndex + 1);
                    }
                    System.out.println(lastIndex);
                    break;
                }
                case "Remove": {
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
                    string.delete(startIndex, startIndex + count);
                    System.out.println(string);
                    break;
                }
            }
            input = scanner.nextLine();
        }
    }
}
