/*
    https://judge.softuni.org/Contests/Practice/Index/1313#0

    01. Ranking

Here comes the final and the most interesting part - the Final ranking of the candidate-interns.
The final ranking is determined by the points of the interview tasks and from the exams in SoftUni.
Here is your final task. You will receive some lines of input in the format "{contest}:{password for contest}"
until you receive "end of contests". Save that data because you will need it later.
After that you will receive other type of inputs in format "{contest}=>{password}=>{username}=>{points}"
until you receive "end of submissions". Here is what you need to do:
•	Check if the contest is valid (if you received it in the first type of input)
•	Check if the password is correct for the given contest
•	Save the user with the contest they take part in (a user can take part in many contests)
and the points the user has in the given contest. If you receive the same contest and the same user,
update the points only if the new ones are more than the older ones.
At the end you have to print the info for the user with the most points in the format
"Best candidate is {user} with total {total points} points.".
After that print all students ordered by their names.
For each user print each contest with the points in descending order. See the examples.

Input
•	Strings in format "{contest}:{password for contest}" until the "end of contests" command.
    There will be no case with two equal contests
•	Strings in format "{contest}=>{password}=>{username}=>{points}" until the "end of submissions" command
•	There will be no case with 2 or more users with same total points!

Output
•	On the first line print the best user in format
"Best candidate is {user} with total {total points} points.".
•	Then print all students ordered as mentioned above in format:
{user1 name}
#  {contest1} -> {points}
#  {contest2} -> {points}

Constraints
•	The strings may contain any ASCII character except from (:, =, >)
•	The numbers will be in range [0 - 10000]
•	Second input is always valid
 */

package L08AssociativeArrays.Exercise.More.T01Ranking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,LinkedHashMap<String,Integer>> users = new LinkedHashMap<>();
        LinkedHashMap<String, String> contestPasswords = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> cumulativeUserPoints = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String[] data = input.split(":"); // {contest}:{password for contest}
            contestPasswords.put(data[0], data[1]);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {

            String[] data = input.split("=>"); // {contest}=>{password}=>{username}=>{points}

            if(contestPasswords.containsKey(data[0]) && contestPasswords.get(data[0]).equals(data[1])) {
                // Contest exists and the password is correct
                int points = Integer.parseInt(data[3]);
                if(users.containsKey(data[2])) { // contains user
                    if(users.get(data[2]).get(data[0]) == null)
                        users.get(data[2]).put(data[0],points);
                    else if(users.get(data[2]).get(data[0]).compareTo(points) < 0)
                        users.get(data[2]).put(data[0], points); //if points are higher than recorded, put new points
                } else {
                    LinkedHashMap<String, Integer> contestPoints = new LinkedHashMap<>();
                    contestPoints.put(data[0], points);
                    users.put(data[2], contestPoints ); // add user and contest points
                }
            }
            input = scanner.nextLine();
        }
        users.forEach((user, contest) -> {
            int cumulativePoints = 0;

            for(Map.Entry<String, Integer> entry : contest.entrySet()) {
                cumulativePoints += entry.getValue();
            }
            cumulativeUserPoints.put(cumulativePoints, user);
        });

        cumulativeUserPoints.entrySet().stream().sorted((a,b) -> b.getKey().compareTo(a.getKey()))
                .limit(1).forEach(a -> System.out.printf("Best candidate is %s with total %d points.%n",
                        a.getValue(), a.getKey()));
        System.out.println("Ranking: ");
        users.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(a -> {
            System.out.println(a.getKey());
            a.getValue().entrySet().stream().sorted((c, d) -> d.getValue().compareTo(c.getValue())).forEach(entry -> {
                System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue());
            });
        });
    }
}
