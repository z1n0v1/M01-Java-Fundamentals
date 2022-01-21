package Exam.E06Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chestContents = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Loot": {
                    for (int loot = 1; loot < command.length; loot++) {
                        if (!chestContents.contains(command[loot])) {
                            chestContents.add(0, command[loot]);
                        }
                    }
                    break;
                }
                case "Drop": {
                    int index = Integer.parseInt(command[1]);
                    if (index >= 0 && index < chestContents.size()) {
                        String item = chestContents.get(index);
                        chestContents.remove(index);
                        chestContents.add(item);
                    }
                    break;
                }
                case "Steal": {
                    int numItems = Integer.parseInt(command[1]);

                    if (numItems > chestContents.size())
                        numItems = chestContents.size();

                    int startIndex = chestContents.size() - numItems;
                    int endIndex = chestContents.size() - 1;
                    for (int item = startIndex; item < endIndex; item++) {
                        System.out.printf("%s, ", chestContents.remove(item));
                        item--;
                        endIndex--;
                    }
                    System.out.println(chestContents.remove(chestContents.size() - 1));
             /*
                    while (numItems > 0 && chestContents.size() > 0) {
                        if (numItems == 1)
                            System.out.printf("%s%n", chestContents.remove(chestContents.size() - 1));
                        else System.out.printf("%s, ", chestContents.remove(chestContents.size() - 1));
                        numItems--;
                    }
             */
                    break;
                }
            }
//            System.out.println(chestContents);
            input = scanner.nextLine();
        }
        if (chestContents.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            int treasureGain = 0;
            for (String treasure : chestContents)
                treasureGain += treasure.length();
            System.out.printf("Average treasure gain: %.2f pirate credits.", 1.0 * treasureGain / chestContents.size());
        }
    }
}
