/*
    https://judge.softuni.org/Contests/Compete/Index/1670#2

    03. Extract File

Write a program that reads the path to a file and subtracts the file name and its extension.
 */

package L09TextProcessing.Exercise.T03ExtractFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pathToFile = scanner.nextLine().split("[\\\\ .]+");
        System.out.printf("File name: %s%n", pathToFile[pathToFile.length - 2]);
        System.out.printf("File extension: %s%n", pathToFile[pathToFile.length - 1]);

    }
}
