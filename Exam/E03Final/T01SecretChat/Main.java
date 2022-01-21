package Exam.E03Final.T01SecretChat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] command = input.split("\\:\\|\\:");
            boolean error = false;
            switch (command[0]) {
                case "InsertSpace": {
                    int index = Integer.parseInt(command[1]);
                    message.insert(index, " ");
                    break;
                }
                case "Reverse": {
                    int index = message.indexOf(command[1]);
                    int length = command[1].length();
                    if (index != -1) {
                        message.delete(index, index + length);
                        message.append(new StringBuilder(command[1]).reverse());
                    } else {
                        System.out.println("error");
                        error = true;
                    }
                    break;
                }
                case "ChangeAll": {
                    message = new StringBuilder(message.toString().replaceAll(command[1], command[2]));
                    break;
                }
            }
            if (!error) System.out.println(message);
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
