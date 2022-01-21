/*
    https://judge.softuni.org/Contests/Practice/Index/1226#9

    10. Rage Expenses

As a MOBA challenger player, Peter has the bad habit to trash his PC when he loses a game and rage quits.
His gaming setup consists of headset, mouse, keyboard and display. You will receive Peter`s lost games count.

Every second lost game, Peter trashes his headset.
Every third lost game, Peter trashes his mouse.

When Peter trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
Every second time, when he trashes his keyboard, he also trashes his display.

You will receive the price of each item in his gaming setup. Calculate his rage expenses for renewing his gaming equipment.

Input / Constraints
•	On the first input line - lost games count – integer in the range [0, 1000].
•	On the second line – headset price - floating point number in range [0, 1000].
•	On the third line – mouse price - floating point number in range [0, 1000].
•	On the fourth line – keyboard price - floating point number in range [0, 1000].
•	On the fifth line – display price - floating point number in range [0, 1000].

Output
•	As output you must print Peter`s total expenses: "Rage expenses: {expenses} lv."
•	Allowed working time / memory: 100ms / 16MB.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T10RageExpenses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        //int trashedHeadsets = lostGames / 2;
        //int trashedMouse = lostGames / 3;

        int trashedHeadsets = 0, trashedMouse = 0, trashedKeyboard = 0, trashedDisplay = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) trashedHeadsets++;
            if (i % 3 == 0) trashedMouse++;
            if (i % 2 == 0 && i % 3 == 0) trashedKeyboard++;
        }
        trashedDisplay = trashedKeyboard / 2;

        double rageExpenses = headsetPrice * trashedHeadsets + mousePrice * trashedMouse
                + keyboardPrice * trashedKeyboard + displayPrice * trashedDisplay;

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);

    }
}
