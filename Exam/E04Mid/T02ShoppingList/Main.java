/*
    https://judge.softuni.org/Contests/Practice/Index/2031#1

    02. Shopping List

It's the end of the week, and it is time for you to go shopping, so you need to create a shopping list first.

Input
You will receive an initial list with groceries separated by an exclamation mark "!".
After that, you will be receiving 4 types of commands until you receive "Go Shopping!".
•	"Urgent {item}" - add the item at the start of the list.  If the item already exists, skip this command.
•	"Unnecessary {item}" - remove the item with the given name, only if it exists in the list. Otherwise, skip this command.
•	"Correct {oldItem} {newItem}" - if the item with the given old name exists, change its name with the new one.
     Otherwise, skip this command.
•	"Rearrange {item}" - if the grocery exists in the list, remove it from its current position and add it at the end of the list.
     Otherwise, skip this command.

Constraints
•	There won't be any duplicate items in the initial list
Output

•	Print the list with all the groceries, joined by ", ":
"{firstGrocery}, {secondGrocery}, … {nthGrocery}"
 */

package Exam.E04Mid.T02ShoppingList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!(input.equals("Go Shopping!"))) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "Urgent": {
                    if (!isOnList(groceries, data[1]))
                        groceries.add(0, data[1]);
                    break;
                }
                case "Correct": {
                    for (int i = 0; i < groceries.size(); i++) {
                        if (groceries.get(i).equals(data[1])) {
                            groceries.set(i, data[2]);
                            break;
                        }
                    }
                    break;
                }
                case "Rearrange": {
                    int index = findInList(groceries, data[1]);
                    if (index >= 0) {
                        String item = groceries.get(index);
                        groceries.remove(index);
                        groceries.add(item);
                    }
                    break;
                }
                case "Unnecessary": {
                    int index = findInList(groceries, data[1]);
                    if (index >= 0) {
                        groceries.remove(index);
                    }
                }
            }
            input = scanner.nextLine();
        }

        if (groceries.size() > 1)
            for (int i = 0; i < groceries.size() - 1; i++)
                System.out.printf("%s, ", groceries.get(i));
        System.out.println(groceries.get(groceries.size() - 1));

    }

    private static int findInList(List<String> groceries, String item) {
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).equals(item))
                return i;
        }
        return -1;
    }

    private static boolean isOnList(List<String> groceries, String item) {
        for (String currentItem : groceries)
            if (currentItem.equals(item))
                return true;
        return false;
    }
}
