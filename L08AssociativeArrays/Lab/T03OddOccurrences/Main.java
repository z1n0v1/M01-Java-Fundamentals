/*
    https://judge.softuni.org/Contests/Practice/Index/1311#2

    Write a program that extracts from a given sequence of words all elements
    that are present in it an odd number of times (case-insensitive).
•	Words are given in a single line, space separated
•	Print the result elements in lowercase in their order of appearance

 */

package L08AssociativeArrays.Lab.T03OddOccurrences;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> e.toLowerCase(Locale.ROOT)).collect(Collectors.toList());

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String element : elements) {
            if (counts.containsKey(element)) {
                counts.put(element, counts.get(element) + 1);
            } else {
                counts.put(element, 1);
            }
        }

        List<String> oddElements = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1)
                oddElements.add(entry.getKey());
        }
        for (int i = 0; i < oddElements.size(); i++) {
            System.out.print(oddElements.get(i));
            if (i < oddElements.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}
