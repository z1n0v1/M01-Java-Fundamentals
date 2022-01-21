/*
    https://judge.softuni.org/Contests/Practice/Index/1461#4

    05. Messages

Write a program, which emulates typing an SMS, following this guide:

    1      2       3
          abc     def
    4      5       6
   ghi    jkl     mno
    7      8       9
  pqrs    tuv     wxyz
           0
         space

Following the guide, 2 becomes “a”, 22 becomes “b” and so on.

Hints
•	A native approach would be to just put all the possible combinations of digits in a giant switch statement.
•	A cleverer approach would be to come up with a mathematical formula, which converts a number to its alphabet representation:

Digit       2       3       4         5           6           7           8            9
Index     0 1 2 | 3 4 5 | 6 7 8  | 9 10 11  | 12 13 14 | 15 16 17 18 | 19 20 21 | 22 23 24 25
Letter    a b c | d e f | g h i  | j k l    | m  n  o  | p  q  r  s  | t  u  v  | w  x  y  z

•	Let’s take the number 222 (c) for example. Our algorithm would look like this:
o	Find the number of digits the number has “e.g. 222  3 digits”
o	Find the main digit of the number “e.g.  222  2”
o	Find the offset of the number. To do that, you can use the formula: (main digit - 2) * 3
o	If the main digit is 8 or 9, we need to add 1 to the offset, since the digits 7 and 9 have 4 letters each
o	Finally, find the letter index (a  0, c  2, etc.). To do that, we can use the following formula:
    (offset + digit length - 1).
o	After we’ve found the letter index, we can just add that to the ASCII code of the lowercase letter “a” (97)

 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.More.T05Messages;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String message = "";
        for (int i = 0; i < length; i++) {
            String pressedNumbers = scanner.nextLine();
            int numDigits = pressedNumbers.length();
            int mainDigit = Integer.parseInt(pressedNumbers.substring(0,1));
            if (mainDigit == 0) {
                message+=" ";
                continue;
            }
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 | mainDigit == 9)
                offset++;
            int letterIndex = offset + numDigits - 1;
            message += String.format("%c", (char) ('a' + letterIndex));
        }
        System.out.println(message);

        /* native approach

        for (int i = 0; i < length; i++) {
            String pressedNumbers = scanner.nextLine();
            switch (pressedNumbers.charAt(0)) {
                case '0': {
                    System.out.print(' ');
                    break;
                }
                case '2': {
                    if(pressedNumbers.length() == 1) System.out.print('a');
                    if(pressedNumbers.length() == 2) System.out.print('b');
                    if(pressedNumbers.length() == 3) System.out.print('c');
                    break;
                }
                case '3': {
                    if(pressedNumbers.length() == 1) System.out.print('d');
                    if(pressedNumbers.length() == 2) System.out.print('e');
                    if(pressedNumbers.length() == 3) System.out.print('f');
                    break;
                }
                case '4': {
                    if(pressedNumbers.length() == 1) System.out.print('g');
                    if(pressedNumbers.length() == 2) System.out.print('h');
                    if(pressedNumbers.length() == 3) System.out.print('i');
                    break;
                }
                case '5': {
                    if(pressedNumbers.length() == 1) System.out.print('j');
                    if(pressedNumbers.length() == 2) System.out.print('k');
                    if(pressedNumbers.length() == 3) System.out.print('l');
                    break;
                }
                case '6': {
                    if(pressedNumbers.length() == 1) System.out.print('m');
                    if(pressedNumbers.length() == 2) System.out.print('n');
                    if(pressedNumbers.length() == 3) System.out.print('o');
                    break;
                }
                case '7': {
                    if(pressedNumbers.length() == 1) System.out.print('p');
                    if(pressedNumbers.length() == 2) System.out.print('q');
                    if(pressedNumbers.length() == 3) System.out.print('r');
                    if(pressedNumbers.length() == 4) System.out.print('s');
                    break;
                }
                case '8': {
                    if(pressedNumbers.length() == 1) System.out.print('t');
                    if(pressedNumbers.length() == 2) System.out.print('u');
                    if(pressedNumbers.length() == 3) System.out.print('v');
                    break;
                }
                case '9': {
                    if(pressedNumbers.length() == 1) System.out.print('w');
                    if(pressedNumbers.length() == 2) System.out.print('x');
                    if(pressedNumbers.length() == 3) System.out.print('y');
                    if(pressedNumbers.length() == 4) System.out.print('z');
                    break;
                }

            }

        }

         */
    }
}
