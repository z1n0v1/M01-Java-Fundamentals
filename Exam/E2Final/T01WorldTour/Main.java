/*
    https://judge.softuni.org/Contests/Practice/Index/2518#0

    01. World Tour

You are a world traveller and your next goal is to make a world tour.
In order to do that, you have to plan out everything first.
To start with, you would like to plan out all of your stops where you will have a break.
On the first line you will be given a string containing all of your stops. Until you receive the command "Travel",
you will be given some commands to manipulate that initial string. The commands can be:
•	Add Stop:{index}:{string} – insert the given string at that index only if the index is valid
•	Remove Stop:{start_index}:{end_index} – remove the elements of the string from the starting index to the end index (inclusive)
    if both indices are valid
•	Switch:{old_string}:{new_string} – if the old string is in the initial string, replace it with the new one. (all occurrences)
Note: After each command print the current state of the string
After the "Travel" command, print the following: "Ready for world tour! Planned stops: {string}"
Input / Constraints
•	JavaScript: you will receive a list of strings
Output
•	Print the proper output messages in the proper cases as described in the problem description

 */

package Exam.E2Final.T01WorldTour;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] data = input.split("\\s*\\:\\s*");
            switch (data[0]) {
                case "Add Stop": {
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < stops.length()) {
                        stops.insert(index, data[2]);
                    } else if(index == stops.length())
                        stops.append(data[1]);

                    break;
                }
                case "Remove Stop": {
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);

                    if(startIndex>=0 && startIndex<=endIndex && endIndex<stops.length()) {
                        stops.delete(startIndex, endIndex +1);
                    }
                    break;
                }
                case "Switch": {


                        stops = new StringBuilder(stops.toString().replaceAll(data[1], data[2]));
//                        Pattern pattern = Pattern.compile(data[1]);
//                        Matcher m = pattern.matcher(stops);
//                        int start = 0;
//                        while (m.find(start)) {
//                            stops.replace(m.start(), m.end(), data[2]);
//                            start = m.start() + data[2].length();
//                        }

//                        int index = stops.indexOf(data[1]);
//                        while (index != -1) {
//                            stops.replace(index, index + data[1].length(), data[2]);
//                            index += data[2].length();
//                            index = stops.indexOf(data[1], index);
//                        }

                    break;
                }
            }
            System.out.println(stops);
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }
}
