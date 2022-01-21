/*
    https://judge.softuni.org/Contests/Practice/Index/1270#3

    04. Refactoring: Prime Checker

You are given a program that checks if numbers in a given range [2...N] are prime.
For each number is printed "{number} -> {true or false}". The code however, is not very well written.
Your job is to modify it in a way that is easy to read and understand.

Scanner chetec = new Scanner(System.in);

int ___Do___ = Integer.parseInt(chetec.nextLine());
for (int takoa = 2; takoa <= ___Do___; takoa++) {
    boolean takovalie = true;
    for (int cepitel = 2; cepitel < takoa; cepitel++) {
        if (takoa % cepitel == 0) {
            takovalie = false;
            break;
        }
    }
    System.out.printf("%d -> %b%n", takoa, takovalie);
}
 */

package L02L08DataTypesAndVariables.Exercise.More.T04RefactoringPrimeChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int checkIfPrime = 2; checkIfPrime <= n; checkIfPrime++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor < checkIfPrime; divisor++) {
                if (checkIfPrime % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", checkIfPrime, isPrime);

        }
    }
}
