/*
    https://judge.softuni.org/Contests/Compete/Index/1673#1

    02. Race

Write a program that processes information about a race.
On the first line you will be given a list of participants separated by ", ".
On the next few lines until you receive a line "end of race" you will be given some info which will be some alphanumeric characters.
In between them you could have some extra characters which you should ignore. For example: "G!32e%o7r#32g$235@!2e".
The letters are the name of the person and the sum of the digits is the distance he ran. So here we have George who ran 29 km.
Store the information about the person only if the list of racers contains the name of the person.
If you receive the same person more than once just add the distance to his old distance.
At the end print the top 3 racers ordered by distance in descending in the format:
"1st place: {first racer}
2nd place: {second racer}
3rd place: {third racer}"

 */

package L10RegularExpressions.Exercise.T02Race;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] participantNames = scanner.nextLine().split(", ");
        LinkedHashMap<String, Integer> participantsDistance = new LinkedHashMap<>();

        for (String name : participantNames) {
            participantsDistance.put(name, 0);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            String name = getName(input);
            int distance = getDistance(input);

            if (participantsDistance.containsKey(name)) {
                participantsDistance.put(name, participantsDistance.get(name) + distance);
            }

            input = scanner.nextLine();
        }

        List<Map.Entry<String, Integer>> winnerList = participantsDistance.entrySet().stream().
                sorted((a, b) -> b.getValue().compareTo(a.getValue())).limit(3).distinct().collect(Collectors.toList());

        System.out.printf("1st place: %s%n", winnerList.get(0).getKey());
        System.out.printf("2nd place: %s%n", winnerList.get(1).getKey());
        System.out.printf("3rd place: %s%n", winnerList.get(2).getKey());
    }


    private static int getDistance(String encodedDistance) {
        int distance = 0;

        Matcher digitMatcher = Pattern.compile("[0-9]").matcher(encodedDistance);

        while (digitMatcher.find())
            distance += Integer.parseInt(digitMatcher.group());
        return distance;
    }

    private static String getName(String encodedName) {
        Pattern characters = Pattern.compile("([a-zA-Z]+)");
        Matcher nameMatcher = characters.matcher(encodedName);

        StringBuilder name = new StringBuilder();
        while (nameMatcher.find())
            name.append(nameMatcher.group());
        return name.toString();
    }
}
