/*
    https://judge.softuni.org/Contests/Practice/Index/1286#3

    04. Password Validator

Write a program that checks if a given password is valid. Password rules are:
•	6 – 10 characters (inclusive);
•	Consists only of letters and digits;
•	Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule print a message:
•	"Password must be between 6 and 10 characters";
•	"Password must consist only of letters and digits";
•	"Password must have at least 2 digits".
 */

package L04Methods.Exercise.T04PasswordValidator1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean hasTwoDigits = hasTwoDigits(password);
        boolean isBetween6And10 = isBetween6And10(password);
        boolean isOnlyLettersAndDigits = isOnlyLettersAndDigits(password);

        if (!isBetween6And10)
            System.out.println("Password must be between 6 and 10 characters");
        if (!isOnlyLettersAndDigits)
            System.out.println("Password must consist only of letters and digits");
        if (!hasTwoDigits)
            System.out.println("Password must have at least 2 digits");
        if ( hasTwoDigits && isBetween6And10 && isOnlyLettersAndDigits)
            System.out.println("Password is valid");
    }

    private static boolean hasTwoDigits(String password) {
        int numDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
                numDigits++;
        }
        return numDigits >= 2;
    }

    private static boolean isBetween6And10(String password) {
        return !(password.length()< 6 || password.length() > 10);
    }

    private static boolean isOnlyLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (
                    !(password.charAt(i) >= '0' && password.charAt(i) <= '9')
                            && !(password.charAt(i) >= 'A' && password.charAt(i) <= 'z')
            ) return false;
        }
        return true;
    }
}
