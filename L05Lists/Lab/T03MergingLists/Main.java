/*
    https://judge.softuni.org/Contests/Practice/Index/1295#2

    03. Merging Lists

You are going to receive two lists with numbers. Create a result list which contains the numbers from both of the lists.
The first element should be from the first list, the second from the second list and so on.
If the length of the two lists are not equal, just add the remaining elements at the end of the list.

Hint
•	Read the two lists
•	Create a result list
•	Start looping through them until you reach the end of the smallest one
•	Finally add the remaining elements (if any) to the end of the list
 */

package L05Lists.Lab.T03MergingLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultingList = new ArrayList<>();

        while (firstList.size() > 0 && secondList.size() > 0) {
            resultingList.add(firstList.get(0));
            firstList.remove(0);
            resultingList.add(secondList.get(0));
            secondList.remove(0);
        }
        resultingList.addAll(firstList);
        resultingList.addAll(secondList);

        for (Integer e : resultingList) {
            System.out.printf("%d ", e);
        }
    }
}
