/*
    https://judge.softuni.org/Contests/Practice/Index/1297#2

    03. House Party

Write a program that keeps track of the guests that are going to a house party.
On the first input line you are going to receive how many commands you are going to have.
On the next lines you are going to receive some of the following inputs:
-	"{name} is going!"
-	"{name} is not going!"
If you receive the first type of input, you have to add the person if he/she is not in the list.
(If he/she is in the list print on the console: "{name} is already in the list!").
If you receive the second type of input, you have to remove the person if he/she is in the list.
(If not print: "{name} is not in the list!"). At the end print all guests.

 */

package L05Lists.Exercise.T03HouseParty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = Integer.parseInt(scanner.nextLine());
        List<String> partyList = new ArrayList<>();

        for (int i = 0; i < numCommands; i++) {
            String[] cmd = scanner.nextLine().split(" ");
            if(cmd[2].equals("not")) {
                if(partyList.contains(cmd[0]))
                    partyList.remove(cmd[0]);
                else System.out.printf("%s is not in the list!%n", cmd[0]);
            } else {
                if(partyList.contains(cmd[0]))
                    System.out.printf("%s is already in the list!%n", cmd[0]);
                else partyList.add(cmd[0]);
            }
        }
        for (String name : partyList)
            System.out.println(name);
    }
}
