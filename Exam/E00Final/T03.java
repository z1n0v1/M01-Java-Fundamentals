package Exam.E00Final;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class T03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,Integer> neededFood = new LinkedHashMap<>();
        LinkedHashMap<String,String> areas = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("EndDay")) {
            String[] command = input.split("\\: ");
            switch (command[0]) {
                case "Add": {
                    String[] data = command[1].split("-");

                    String name = data[0];
                    int food = Integer.parseInt(data[1]);
                    String area = data[2];

                    
                    break;
                }
                case "Feed": {

                    break;
                }
            }
        }


    }
}
