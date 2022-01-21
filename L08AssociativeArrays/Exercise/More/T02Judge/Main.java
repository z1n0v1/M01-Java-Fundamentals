/*
    https://judge.softuni.org/Contests/Practice/Index/1313#1

    02. Judge

You know the jude system, right?! Your job is to create a program similar to the Judge system.
You will receive several input lines in the following format:
{username} -> {contest} -> {points}
The constestName and username are strings, the given points will be an integer number.
You need to keep track of every contest and individual statistics of every user.
You should check if such contest already exists, and if not, add it, otherwise check
if the current user is participating in the contest, if he is participating take the higher score, otherwise just add it.
Also you need to keep individual statistics for each user - the total points of all constests.
You should end your program when you receive the command "no more time".
At that point you should print each contest in order of input,
for each contest print the participants ordered by points in desecending order, than ordered by name in ascending order.
After that, you should print individual statistics for every participant ordered by total points in desecnding order,
and then by alphabetical order.

Input / Constraints
•	The input comes in the form of commands in the format specified above
•	Username and contest name always will be one word
•	Points will be an integer in range [0, 1000]
•	There will be no invalid input lines
•	If all sorting criteria fail, the order should be by order of input
•	The input ends when you receive the command "no more time"

Output
•	The output format for the contests is:
{constestName}: {participants.Count} participants
{position}. {username} <::> {points}
•	After you print all contests, print the individual statistics for every participant
•	The output format is:
Individual standings:
{position}. {username} -> {totalPoints}
 */

package L08AssociativeArrays.Exercise.More.T02Judge;

import java.util.*;

public class Main {
    static LinkedHashMap<String, LinkedHashMap<String, Integer>> contests; // contest, users, points
    static LinkedHashMap<String, Integer> userCumulativePoints; // user, cumulative points

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        contests = new LinkedHashMap<>();
        userCumulativePoints = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            String[] data = input.split(" -> "); // username -> contest -> points

            int points = Integer.parseInt(data[2]);
            if (!contests.containsKey(data[1])) {
                LinkedHashMap<String, Integer> userPoints = new LinkedHashMap<>();
                userPoints.put(data[0], points);
                contests.put(data[1], userPoints);
            } else {
                LinkedHashMap<String, Integer> contest = contests.get(data[1]);
                if (contest.containsKey(data[0])) {
                    if (contest.get(data[0]).compareTo(points) < 0) {
                        contest.put(data[0], points); // update user points if more than recorded
                    }
                } else {
                    contest.put(data[0], points);
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> contest : contests.entrySet()) {
            for (Map.Entry<String, Integer> user : contest.getValue().entrySet()) {

                String userName = user.getKey();

                if(!userCumulativePoints.containsKey(userName)) {
                    userCumulativePoints.put(userName, user.getValue());
                } else {
                    userCumulativePoints.put(userName, userCumulativePoints.get(userName) + user.getValue());
                }
            }
        }

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue().equals(b.getValue()))
                    return a.getKey().compareTo(b.getKey());
                return b.getValue().compareTo(a.getValue());
            }
        };

        contests.forEach((contestName, userList) -> {
            System.out.printf("%s: %d participants%n", contestName, userList.size());

            List<Map.Entry<String, Integer>> listOfUsers = new ArrayList<>(userList.entrySet());

            Collections.sort(listOfUsers, comparator);

            for (int i = 0; i < listOfUsers.size(); i++) {
                System.out.printf("%d. %s <::> %d%n", i + 1,
                        listOfUsers.get(i).getKey(), listOfUsers.get(i).getValue());
            }
        });

        List<Map.Entry<String, Integer>> cumulativeStandings = new ArrayList<>(userCumulativePoints.entrySet());

        Collections.sort(cumulativeStandings, comparator);

        System.out.println("Individual standings:");
        for (int i = 0; i < cumulativeStandings.size(); i++) {
            System.out.printf("%d. %s -> %d%n", i + 1,
                    cumulativeStandings.get(i).getKey(), cumulativeStandings.get(i).getValue());
        }
    }
}
