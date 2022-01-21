/*
    https://judge.softuni.org/Contests/Practice/Index/1312#4

    05. SoftUni Parking

SoftUni just got a new parking lot. It's so fancy, it even has online parking validation.
Except, the online service doesn't work. It can only receive users' data, but doesn't know what to do with it.
Good thing you're on the dev team and know how to fix it, right?
Write a program, which validates parking for an online service. Users can register to park and unregister to leave.
The program receives 2 commands:
•	"register {username} {licensePlateNumber}":
o	The system only supports one car per user at the moment, so if a user tries to register another license plate,
using the same username, the system should print:
"ERROR: already registered with plate number {licensePlateNumber}"
o	If the aforementioned checks pass successfully, the plate can be registered, so the
system should print:
 "{username} registered {licensePlateNumber} successfully"
•	"unregister {username}":
o	If the user is not present in the database, the system should print:
"ERROR: user {username} not found"
o	If the aforementioned check passes successfully, the system should print:
"{username} unregistered successfully"
After you execute all of the commands, print all the currently registered users and their license plates in the format:
•	"{username} => {licensePlateNumber}"

Input
•	First line: n - number of commands - integer
•	Next n lines: commands in one of two possible formats:
o	Register: "register {username} {licensePlateNumber}"
o	Unregister: "unregister {username}"
The input will always be valid and you do not need to check it explicitly.

 */

package L08AssociativeArrays.Exercise.T05SoftUniParking;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> parking = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            if (data[0].equals("register")) {
                if (parking.containsKey(data[1])) {
                    System.out.printf("ERROR: already registered with plate number %s%n", parking.get(data[1]));
                } else {
                    parking.put(data[1], data[2]);
                    System.out.printf("%s registered %s successfully%n", data[1], data[2]);
                }
            } else {
                if (parking.containsKey(data[1])) {
                    parking.remove(data[1]);
                    System.out.printf("%s unregistered successfully%n", data[1]);
                } else {
                    System.out.printf("ERROR: user %s not found%n", data[1]);
                }
            }
        }
        for (Map.Entry<String, String> entry : parking.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }

    }
}
