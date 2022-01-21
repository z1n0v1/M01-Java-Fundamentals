/*
    https://judge.softuni.org/Contests/Practice/Index/2031#0

    01. Guinea Pig

Merry has a guinea pig named Puppy, that she loves very much.
Every month she goes to the nearest pet store and buys him everything he needs – food, hay, and cover.
On the first line, you will receive the quantity of food, which Merry buys for a month (30 days). On the second line,
you will receive quantity hay, and on the third line – quantity cover, also for a month.
On the fourth line, you will receive the guinea pig's weight.  All values are in kilograms.

Calculate whether the quantity of food, hay, and cover, will be enough for a month.
The amount of food given to the guinea pig each day is 300 gr.
Every second day Merry gives hay, which is 5% of the rest of the food.
On every third day, Merry put cover, which is 1/3 of the guinea pig's weight.

Puppy eats food every single day!
If food, hay, or cover runs out, stop the program.

Input:
•	On the first line – quantity food in kilograms - a floating-point number in the range [0.0 – 10000.0]
•	On the second line – quantity hay in kilograms - a floating-point number in the range [0.0 – 10000.0]
•	On the third line – quantity cover in kilograms - a floating-point number in the range [0.0 – 10000.0]
•	On the fourth line – guinea's weight in kilograms - a floating-point number in the range [0.0 – 10000.0]

Output:
•	If the food, the hay, and the cover are enough, print:
o	"Everything is fine! Puppy is happy! Food: {excessFood}, Hay: {excess hay}, Cover: {excessCover}."
•	If one of the things is not enough, print:
o	"Merry must go to the pet store!"

The output must be formatted to the second decimal place!

 */

package Exam.E04Mid.T01GuineaPig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine()) * 1000;
        double hay = Double.parseDouble(scanner.nextLine()) * 1000;
        double cover = Double.parseDouble(scanner.nextLine()) * 1000;
        double weight = Double.parseDouble(scanner.nextLine()) * 1000;

        for (int i = 1; i <= 30; i++) {
            food -= 300;
            if (i % 2 == 0) {
                hay -= food * 0.05;
            }
            if (i % 3 == 0) {
                cover -= weight / 3;
            }
        }
        if (food < 0 || hay < 0 || cover < 0) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    food / 1000, hay / 1000, cover / 1000);
        }
    }
}
