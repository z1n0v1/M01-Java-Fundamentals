/*
    https://judge.softuni.org/Contests/Practice/Index/1227#4

    05. Concat Names

Read two names and a delimiter. Print the names joined by the delimiter.
 */

package L02L08DataTypesAndVariables.Lab.T05ConcatNames;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.println(firstName + delimiter + secondName);
    }
}
