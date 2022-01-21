/*
    https://judge.softuni.org/Contests/Practice/Index/1312#2

    03. Legendary Farming

You've beaten all the content and the last thing left to accomplish is own a legendary item.
However, it's a tedious process and requires quite a bit of farming.
Anyway, you are not too pretentious - any legendary will do. The possible items are:
•	Shadowmourne - requires 250 Shards
•	Valanyr - requires 250 Fragments
•	Dragonwrath - requires 250 Motes
Shards, Fragments and Motes are the key materials, all else is junk.
You will be given lines of input, such as "2 motes 3 ores 15 stones".
Keep track of the key materials - the first that reaches the 250 mark wins the race.
At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments,
motes, ordered by quantity in descending order, then by name in ascending order, each on a new line.
Finally, print the collected junk items, in alphabetical order.

Input
•	Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}

Output
•	On the first line, print the obtained item in format {Legendary item} obtained!
•	On the next three lines, print the remaining key materials in descending order by quantity
o	If two key materials have the same quantity, print them in alphabetical order
•	On the final several lines, print the junk items in alphabetical order
o	All materials are printed in format {material}: {quantity}
o	All output should be lowercase, except the first letter of the legendary
 */

package L08AssociativeArrays.Exercise.T03LegendaryFarming;

import java.util.*;

public class Main {
    static Map<String, Integer> loot = new LinkedHashMap<>();
    static Map<String, Integer> legendaryLoot = new LinkedHashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        legendaryLoot.put("shards", 0);
        legendaryLoot.put("fragments", 0);
        legendaryLoot.put("motes", 0);

        boolean isFound = false;
        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                gatherLoot(Integer.parseInt(input[i]), input[i + 1]);

                String legendary = enoughForLegendary();
                if (legendary.length() > 0) {
                    System.out.printf("%s obtained!%n", legendary);
                    printFragments();
                    isFound = true;
                    break;
                }
            }
            if (isFound) break;
        }
    }

    static void printFragments() {
        legendaryLoot.entrySet().stream().sorted((a, b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        }).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        loot.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

    }

    static String enoughForLegendary() {
        if (legendaryLoot.get("shards") >= 250) {
            int shards = legendaryLoot.get("shards");
            legendaryLoot.put("shards", shards - 250);
            return "Shadowmourne";
        } else if (legendaryLoot.get("fragments") >= 250) {
            int fragments = legendaryLoot.get("fragments");
            legendaryLoot.put("fragments", fragments - 250);
            return "Valanyr";
        } else if (legendaryLoot.get("motes") >= 250) {
            int motes = legendaryLoot.get("motes");
            legendaryLoot.put("motes", motes - 250);
            return "Dragonwrath";
        } else return "";
    }

    static void gatherLoot(int quantity, String type) {
        type = type.toLowerCase(Locale.ROOT);
        if (type.equals("shards") || type.equals("fragments") || type.equals("motes")) {
            legendaryLoot.put(type, legendaryLoot.get(type) + quantity);
        } else {
            if (loot.containsKey(type))
                loot.put(type, loot.get(type) + quantity);
            else loot.put(type, quantity);
        }
    }
}
