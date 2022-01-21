/*
    https://judge.softuni.org/Contests/Practice/Index/1227#0

    01. Convert Meters to Kilometers

You will be given an integer that will be distance in meters.
Write a program that converts meters to kilometers formatted to the second decimal point.
 */

package L02L08DataTypesAndVariables.Lab.T01ConvertMetersToKilometers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int DistanceInMeters = Integer.parseInt(scanner.nextLine());
        double kilometers = DistanceInMeters / 1000.0;
        System.out.printf("%.2f", kilometers);
    }
}
