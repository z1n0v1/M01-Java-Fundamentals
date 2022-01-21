/*
    https://judge.softuni.org/Contests/Practice/Index/1226#4

    05. Login

You will be given a string representing a username.
The password will be that username reversed. Until you receive the correct password
print on the console "Incorrect password.
Try again.". When you receive the correct password print "User {username} logged in."
However on the fourth try if the password is still not correct print "User {username} blocked!" and end the program.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T05Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        String user = scanner.nextLine();
        String password = input.append(user).reverse().toString();
        boolean loggedIn = false;

        for (int i = 0; i <= 3; i++) {
            String passwordTry = scanner.nextLine();
            if ( password.equals(passwordTry)) {
                loggedIn = true;
                break;
            } else if (i < 3)
                System.out.println("Incorrect password. Try again.");
        }
        if (loggedIn) {
            System.out.printf("User %s logged in.", user);
        } else {
            System.out.printf("User %s blocked!", user);
        }
    }
}
