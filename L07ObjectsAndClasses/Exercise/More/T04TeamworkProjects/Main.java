/*
    https://judge.softuni.org/Contests/Practice/Index/1328#3

    04. Teamwork projects

It's time for teamwork projects and you are responsible for making the teams.
First you will receive an integer - the count of the teams you will have to register.
You will be given a user and a team (separated with “-”).  The user is the creator of that team.

For every newly created team you should print a message:
"Team {team Name} has been created by {user}!".

Next you will receive user with team (separated with "->") which means that the user wants to join that team.
Upon receiving the command: “end of assignment”, you should print every team,
ordered by the count of its members (descending) and then by name (ascending). For each team (disband teams as well),
you have to print its members sorted by name (ascending). However, there are several rules:
•	If user tries to create a team more than once a message should be displayed:
-	"Team {teamName} was already created!"
•	Creator of a team cannot create another team - message should be thrown:
-	"{user} cannot create another team!"
•	If user tries to join currently non-existing team a message should be displayed:
-	"Team {teamName} does not exist!"
•	Member of a team cannot join another team - message should be thrown:
-	"Member {user} cannot join team {team Name}!"
•	In the end (after teams' report) teams with zero members (with only a creator)
    should disband ordered by name in ascending other.
•	 Every valid team should be printed ordered by name (ascending) in this format:
"{teamName}:
- {creator}
-- {member}…"
 */

package L07ObjectsAndClasses.Exercise.More.T04TeamworkProjects;

import java.util.*;

public class Main {
    static List<Team> teams, disbanded;
    static List<User> users;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        teams = new ArrayList<>();
        users = new ArrayList<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] data = scanner.nextLine().split("-");
            if (userExists(data[0])) {
                System.out.printf("%s cannot create another team!%n", data[0]);
            } else {
                if (teamExists(data[1])) {
                    System.out.printf("Team %s was already created!%n", data[1]);
                } else {
                    System.out.printf("Team %s has been created by %s!%n",data[1],data[0]);
                    User creator = new User(data[0]);
                    Team team = new Team(creator, data[1]);
                    teams.add(team);
                    users.add(creator);
                }
            }
        }
        String input = scanner.nextLine();

        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");

            Team team = getTeam(data[1]);
            User user = getUser(data[0]);
            if (team == null) {
                System.out.printf("Team %s does not exist!%n", data[1]);
            } else if (user != null && user.isInTeam()) {
                System.out.printf("Member %s cannot join team %s!%n", data[0], data[1]);
            } else {
                user = new User(data[0]);
                team.addUser(user);
                users.add(user);
            }
            input = scanner.nextLine();
        }
        TeamComparator comparator = new TeamComparator();
        teams.sort(comparator);
        //Collections.reverse(teams);
        disbanded = new ArrayList<>();
        for (Team team : teams) {
            if(team.getNumMembers() == 0) {
                disbanded.add(team);
            } else team.printTeam();
        }
        System.out.println("Teams to disband:");
        for (Team team : teams)
            if(team.getNumMembers() == 0)
               System.out.println(team.getName());
    }

    private static boolean userExists(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return true;
        }
        return false;
    }

    private static Team getTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name))
                return team;
        }
        return null;
    }

    private static User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }

    private static boolean teamExists(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name))
                return true;
        }
        return false;
    }
}
