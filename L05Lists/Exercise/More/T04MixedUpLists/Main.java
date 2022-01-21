/*
    https://judge.softuni.org/Contests/Practice/Index/1308#3

    04. Mixed up Lists

Write a program that mixes up two lists by some rules. You will receive two lines of input,
each one being a list of numbers. The rules for mixing are:
•	Start from the beginning of the first list and from the ending of the second
•	Add element from the first and element from the second
•	At the end there will always be a list in which there are 2 elements remaining
•	These elements will be the range of the elements you need to print
•	Loop through the result list and take only the elements that fulfill the condition
•	Print the elements ordered in ascending order and separated by a space

 */

package L05Lists.Exercise.More.T04MixedUpLists;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> buffer = new ArrayList<>();

        int startRange = 0, endRange = 0;

        while (firstList.size() > 0 && secondList.size() > 0) {
            buffer.add(firstList.get(0));
            firstList.remove(0);
            buffer.add(secondList.get(secondList.size() - 1));
            secondList.remove(secondList.size() - 1);
        }

        if (firstList.size()>0) {
            startRange = firstList.get(0);
            endRange = firstList.get(1);
        } else {
            startRange = secondList.get(0);
            endRange = secondList.get(1);
        }

        List<Integer> result = new ArrayList<>();

        if (endRange < startRange) {
            int tmp = endRange;
            endRange = startRange;
            startRange = tmp;
        }

        for (Integer num : buffer)
            if (num > startRange && num < endRange)
                result.add(num);

        Collections.sort(result);

        for (Integer num : result)
            System.out.printf("%d ", num);
    }
}
