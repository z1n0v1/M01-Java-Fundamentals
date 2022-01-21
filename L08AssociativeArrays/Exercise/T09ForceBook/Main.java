/*
    https://judge.softuni.org/Contests/Practice/Index/1312#8

    09. ForceBook

The force users are struggling to remember which side are the different forceUsers from, because they switch them too often.
So you are tasked to create a web application to manage their profiles.
You should store information for every unique forceUser, registered in the application.
You will receive several input lines in one of the following formats:
{forceSide} | {forceUser}
{forceUser} -> {forceSide}
The forceUser and forceSide are strings, containing any character.
If you receive forceSide | forceUser you should check if such forceUser already exists, and if not - add him/her
to the corresponding side.
If you receive a forceUser -> forceSide you should check if there is such forceUser already and if so, change his/her side.
If there is no such forceUser, add him/her to the corresponding forceSide, treating the command as new registered forceUser.
Then you should print on the console: "{forceUser} joins the {forceSide} side!"
You should end your program when you receive the command "Lumpawaroo".
At that point you should print each force side, ordered descending by forceUsers count, than ordered by name.
For each side print the forceUsers, ordered by name.
In case there are no forceUsers in a side, you shouldn't print the side information.

Input / Constraints
•	The input comes in the form of commands in one of the formats specified above
•	The input ends when you receive the command "Lumpawaroo"

Output
•	As output for each forceSide, ordered descending by forceUsers count, then by name, you must print all the forceUsers,
ordered by name alphabetically
•	The output format is:
Side: {forceSide}, Members: {forceUsers.Count}
! {forceUser}
! {forceUser}
! {forceUser}
•	In case there are NO forceUsers, don't print this side

 */

package L08AssociativeArrays.Exercise.T09ForceBook;

import java.util.*;

public class Main {
    static LinkedHashMap<String, String> forceUsers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        forceUsers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            String forceUser, forceSide;

            if (input.contains("|")) {
                String[] data = input.split(" \\| ");
                forceSide = data[0];
                forceUser = data[1];
                registerUser(forceUser, forceSide);
            } else {
                String[] data = input.split(" -> ");
                forceUser = data[0];
                forceSide = data[1];
                changeSide(forceUser, forceSide);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }

        LinkedHashMap<String, List<String>> forceSides = new LinkedHashMap<>();

        forceUsers.forEach((key, value) -> {
            if (!forceSides.containsKey(value)) {
                List<String> users = new ArrayList<>();
                users.add(key);
                forceSides.put(value, users);
            } else {
                forceSides.get(value).add(key);
            }
        });

        forceSides.entrySet().stream().sorted((a, b) -> {

                    if (a.getValue().size() == b.getValue().size()) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return Integer.compare(b.getValue().size(), a.getValue().size());
                })
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream().sorted().forEach(a -> {
                        System.out.println("! " + a);
                    });
                });


    }

    static void changeSide(String user, String side) {
        forceUsers.put(user, side);
    }

    static void registerUser(String user, String side) {
        if (!forceUsers.containsKey(user))
            forceUsers.put(user, side);
    }
}
