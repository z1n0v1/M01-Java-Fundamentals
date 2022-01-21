/*
    https://judge.softuni.org/Contests/Practice/Index/1312#9

    10. SoftUni Exam Results

Judge statistics on the last Programing Fundamentals exam was not working correctly,
so you have the task to take all the submissions and analyze them properly.
You should collect all the submission and print the final results and statistics about each language
that the participants submitted their solutions in.
You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished".
You should store each username and his submissions and points.
You can receive a command to ban a user for cheating in the following format: "{username}-banned". In that case,
you should remove the user from the contest, but preserve his submissions in the total count of submissions for each language.
After receiving "exam finished", print each of the participants, ordered descending by their max points, then by username,
in the following format:
Results:
{username} | {points}
…
After that print each language, used in the exam, ordered descending by total submission count and then by language name,
in the following format:
Submissions:
{language} - {submissionsCount}
…

Input / Constraints
Until you receive "exam finished", you will be receiving participant submissions in the following format:
"{username}-{language}-{points}"
You can receive a ban command -> "{username}-banned"
The points of the participant will always be a valid integer in the range [0-100]

Output
•	Print the exam results for each participant, ordered descending by max points and then by username, in the following format:
Results:
{username} | {points}
…
•	After that print each language, ordered descending by total submissions and then by language name, in the following format:
Submissions:
{language} - {submissionsCount}
…
•	Allowed working time/memory: 100ms/16MB

 */

package L08AssociativeArrays.Exercise.T10SoftUniExamResults;

import java.util.*;

public class Main {
    static LinkedHashMap<String, Integer> contest;
    static LinkedHashMap<String, Integer> languages;
    static List<String> bannedUsers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        contest = new LinkedHashMap<>();
        languages = new LinkedHashMap<>();
        bannedUsers = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.contains("exam finished")) {
            String[] data = input.split("-");
            if (data[1].equals("banned")) {
                banUser(data[0]);
            } else {
                if (!languages.containsKey(data[1])) {
                    languages.put(data[1], 1);
                } else {
                    languages.put(data[1], languages.get(data[1]) + 1);
                }

                if(!bannedUsers.contains(data[0])) {
                    int points = Integer.parseInt(data[2]);
                    if (!contest.containsKey(data[0])) {
                        contest.put(data[0], points);
                    } else {
                        if (contest.get(data[0]) < points) {
                            contest.put(data[0], points);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");

        contest.entrySet().stream().sorted((a, b) -> {
            if(a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        }).forEach(entry -> System.out.printf("%s | %d%n",entry.getKey(), entry.getValue()));
        System.out.println("Submissions:");

        languages.entrySet().stream().sorted( (a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        }).forEach( entry -> System.out.printf("%s - %d%n",entry.getKey(), entry.getValue()));
    }

    static void banUser(String user) {
        contest.remove(user);
        bannedUsers.add(user);
    }
}
