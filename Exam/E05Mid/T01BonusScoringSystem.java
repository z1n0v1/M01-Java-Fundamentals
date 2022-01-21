package Exam.E05Mid;

import java.util.Scanner;

public class T01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        int numLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxLectures = 0;
        for (int student = 0; student < numStudents; student++) {
            int lectures = Integer.parseInt(scanner.nextLine());

            double totalBonus = 0;
            if(numLectures != 0)
                totalBonus = (1.0 * lectures / numLectures) * (5 + bonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxLectures = lectures;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxLectures);

    }
}
