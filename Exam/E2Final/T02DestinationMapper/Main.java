/*
    https://judge.softuni.org/Contests/Practice/Index/2518#1

    02. Destination Mapper

Now that you have planned out your tour, you are ready to go!
Your next task is to mark all the points on the map that you are going to visit.
You will be given a string representing some places on the map.
You have to filter only the valid ones. A valid location is:
•	Surrounded by "=" or "/" on both sides (the first and the last symbols must match)
•	After the first "=" or "/" there should be only letters (the first must be upper-case, other letters, may be upper or lower-case)
•	The letters must be at least 3
Example: In the string "=Hawai=/Cyprus/=Invalid/invalid==i5valid=/I5valid/=i=" only the first two locations are valid.
After you have matched all the valid locations, you have to calculate travel points.
They are calculated by summing the lengths of all the valid destinations that you have found on the map. At the end,
on the first line print the following: "Destinations: {destinations joined by ', '}".
On the second line print "Travel Points: {travel_points}".

Input / Constraints
•	You will recive a string representing the locations on the map
•	JavaScript: you will receive a single parameter: string

Output
•	Print the messages described above

 */

package Exam.E2Final.T02DestinationMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Matcher destinationMapper = Pattern.compile("([=\\/])(?<destination>[A-Z][a-zA-Z]{2,})\\1").matcher(scanner.nextLine());

        List<String> destinations = new ArrayList<>();
        int points = 0;
        while (destinationMapper.find()) {
            String destination = destinationMapper.group("destination");
            destinations.add(destination);
            points += destination.length();
        }



        if (destinations.size() > 0) {
            System.out.print("Destinations: ");
            for (int i = 0; i < destinations.size() - 1; i++) {
                System.out.printf("%s, ", destinations.get(i));
            }
            System.out.println(destinations.get(destinations.size() - 1));
        } else System.out.println("Destinations:");
        System.out.printf("Travel Points: %d%n", points);

    }
}
