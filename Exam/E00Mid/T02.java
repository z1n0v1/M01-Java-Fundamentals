package Exam.E00Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        int numBlacklisted = 0, numLost = 0;
        String input = scanner.nextLine();
        while (!input.equals("Report")) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "Blacklist": {
                    String name = data[1];
                    int index = list.indexOf(name);
                    if(index == -1) {
                        System.out.printf("%s was not found.%n", name);
                    } else {
                        list.set(index, "Blacklisted");
                        System.out.printf("%s was blacklisted.%n", name);
                        numBlacklisted++;
                    }
                    break;
                }
                case "Error": {
                    int index = Integer.parseInt(data[1]);
                    if(index >= 0 && index < list.size()
                            && !list.get(index).equals("Blacklisted")
                            && !list.get(index).equals("Lost")) {
                        System.out.printf("%s was lost due to an error.%n", list.get(index));
                        list.set(index, "Lost");
                        numLost++;
                    }
                    break;
                }
                case "Change": {
                    int index = Integer.parseInt(data[1]);
                    String newName = data[2];
                    if(index >= 0 && index < list.size()) {
                        String currentName = list.get(index);
                        list.set(index, newName);
                        System.out.printf("%s changed his username to %s.%n", currentName, newName);
                    }
                    break;
                }
            }
            input  = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", numBlacklisted);
        System.out.printf("Lost names: %d%n", numLost);
        for (String name : list)
            System.out.printf("%s ", name);
    }
}
