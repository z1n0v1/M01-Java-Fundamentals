/*
    https://judge.softuni.org/Contests/Practice/Index/1313#3

    04. Snowwhite

Snow White loves her dwarfs, but there are so many and she doesn't know how to order them.
Does she order them by name? Or by color of their hat? Or by physics?
She can't decide, so it's up to you to write a program that does it for her.
You will be receiving several input lines which contain data about dwarfs in the following format:
{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}
The dwarfName and the dwarfHatColor are strings. The dwarfPhysics is an integer.
You must store the dwarfs in your program. There are several rules though:
•	If 2 dwarfs have the same name but different hat color, they should be considered different dwarfs,
and you should store both of them.
•	If 2 dwarfs have the same name and the same hat color, store the one with the higher physics.
When you receive the command "Once upon a time", the input ends.
You must order the dwarfs by physics in descending order and then by total count of dwarfs with the same hat color
in descending order.
Then you must print them all.

Input
•	The input will consists of several input lines, containing dwarf data in the format, specified above
•	The input ends when you receive the command "Once upon a time"

Output
•	As output you must print the dwarfs, ordered in the way, specified above
•	The output format is: ({hatColor}) {name} <-> {physics}

Constraints
•	The dwarfName will be a string which may contain any ASCII character except ' ' (space), '<', ':', '>'
•	The dwarfHatColor will be a string which may contain any ASCII character except ' ' (space), '<', ':', '>'
•	The dwarfPhysics will be an integer in range [0, 231 - 1]
•	There will be no invalid input lines
•	If all sorting criteria fail, the order should be by order of input
•	Allowed working time/memory: 100ms/16MB

 */

package L08AssociativeArrays.Exercise.More.T04Snowwhite;

import java.util.*;

public class Main {

    static LinkedHashMap<String, List<LinkedHashMap<String, Integer>>> dwarfsByHat;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        dwarfsByHat = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Once upon a time")) {
            String[] data = input.split(" <:> ");
            String dwarfName = data[0], dwarfHatColor = data[1];
            int dwarfPhysics = Integer.parseInt(data[2]);
            updateDwarfsByHat(dwarfName, dwarfHatColor, dwarfPhysics);
            input = scanner.nextLine();
        }
//        System.out.println(dwarfsByHat);

        // You must order the dwarfs by physics in descending order and then by total count of dwarfs
        // with the same hat color in descending order. Then you must print them all.
        // If all sorting criteria fail, the order should be by order of input.

        // As output you must print the dwarfs, ordered in the way, specified above
        // The output format is: ({hatColor}) {name} <-> {physics}

        // by phys, by count of dwarfs per hat, than hat, dwarf, phys
        // list of map of phys to list of map of hats to map of total dwarfs to list of dwarfNames and dwarfPhys

        LinkedHashMap<String, Integer> totalDwarfsPerHat = calculateDwarfsPerHat();

        List<LinkedHashMap<Integer,LinkedHashMap<String,String>>> dwarfsByPhysics = getDwarfsByPhysics();

        dwarfsByPhysics.sort((a,b) -> {

            // sort by phys

            Map.Entry<Integer, LinkedHashMap<String, String>> physEntry1 =
                    ((Map<Integer, LinkedHashMap<String, String>>) a).entrySet().iterator().next();
            Map.Entry<Integer, LinkedHashMap<String, String>> physEntry2 =
                    ((Map<Integer, LinkedHashMap<String, String>>) b).entrySet().iterator().next();

            Integer aPhys = physEntry1.getKey();
            Integer bPhys = physEntry2.getKey();

            if (aPhys.equals(bPhys)) {

                Map<String, String> hatAndNameMap1 = physEntry1.getValue();
                Map<String, String> hatAndNameMap2 = physEntry2.getValue();

                Map.Entry<String, String> hatAndNameEntry1 = hatAndNameMap1.entrySet().iterator().next();
                Map.Entry<String, String> hatAndNameEntry2 = hatAndNameMap2.entrySet().iterator().next();

                String hat1 = hatAndNameEntry1.getKey();
                String hat2 = hatAndNameEntry2.getKey();

                Integer hat1Total = totalDwarfsPerHat.get(hat1);
                Integer hat2Total = totalDwarfsPerHat.get(hat2);
                return hat2Total.compareTo(hat1Total);
            }

            return bPhys.compareTo(aPhys);
        });

        for (LinkedHashMap<Integer,LinkedHashMap<String,String>> dwarf : dwarfsByPhysics) {
            Map.Entry<Integer, LinkedHashMap<String, String>> dwarfEntry =
                    ((Map<Integer, LinkedHashMap<String, String>>) dwarf).entrySet().iterator().next();

            int phys = dwarfEntry.getKey();

            Map<String, String> phyAndDwarfNames = dwarfEntry.getValue();
            Map.Entry<String, String> hatAndDwarfName =  phyAndDwarfNames.entrySet().iterator().next();

            String hat = hatAndDwarfName.getKey();
            String name = hatAndDwarfName.getValue();

            System.out.printf("(%s) %s <-> %d%n", hat, name, phys);
        }

      //  System.out.println(dwarfsByPhysics);

    }

    private static List<LinkedHashMap<Integer,LinkedHashMap<String,String>>> getDwarfsByPhysics() {
        List<LinkedHashMap<Integer,LinkedHashMap<String,String>>> dwarfsByPhysics = new ArrayList<>();

        for(Map.Entry<String, List<LinkedHashMap<String, Integer>>> byHat : dwarfsByHat.entrySet()) {

            String hat = byHat.getKey();

            for (LinkedHashMap<String, Integer> dwarfInfo : byHat.getValue()) {

                for(Map.Entry<String,Integer> dwarfs : dwarfInfo.entrySet()) {
                    LinkedHashMap<Integer,LinkedHashMap<String,String>> phys = new LinkedHashMap<>();
                    LinkedHashMap<String,String> hatName = new LinkedHashMap<>();

                    hatName.put(hat, dwarfs.getKey());
                    phys.put(dwarfs.getValue(),hatName);
                    dwarfsByPhysics.add(phys);
                }
            }
        }
        return dwarfsByPhysics;
    }

        // LinkedHashMap<String, List<LinkedHashMap<String, Integer>>> dwarfsByHat
    private static LinkedHashMap<String, Integer> calculateDwarfsPerHat() {
        LinkedHashMap<String, Integer> dwarfsPerHat = new LinkedHashMap<>();

        for(Map.Entry<String, List<LinkedHashMap<String, Integer>>> hat : dwarfsByHat.entrySet()) {
            dwarfsPerHat.put(hat.getKey(), hat.getValue().size());
        }
        return dwarfsPerHat;
    }

    private static LinkedHashMap<String, Integer> findDwarf(List<LinkedHashMap<String, Integer>> dwarfs, String name) {
        for (LinkedHashMap<String, Integer> dwarf : dwarfs) {
            if (dwarf.containsKey(name))
                return dwarf;
        }
        return null;
    }

    private static void updateDwarfsByHat(String name, String hatColor, int dwarfPhysics) {

//    •	If 2 dwarfs have the same name but different hat color, they should be considered different dwarfs,
//      and you should store both of them.
//    •	If 2 dwarfs have the same name and the same hat color, store the one with the higher physics.

        // LinkedHashMap<String, List<LinkedHashMap<String, Integer>>> dwarfsByHat
        List<LinkedHashMap<String, Integer>> dwarfs;
        LinkedHashMap<String, Integer> dwarf;

        if (!dwarfsByHat.containsKey(hatColor)) {
            dwarfs = new ArrayList<>();
            dwarf = new LinkedHashMap<>();

            dwarf.put(name, dwarfPhysics);
            dwarfs.add(dwarf);
            dwarfsByHat.put(hatColor, dwarfs);
        } else {
            dwarfs = dwarfsByHat.get(hatColor);
            dwarf = findDwarf(dwarfs, name);
            if (dwarf == null) {
                dwarf = new LinkedHashMap<>();
                dwarf.put(name, dwarfPhysics);
                dwarfs.add(dwarf);
            } else {
                if (dwarf.get(name) < dwarfPhysics) {
                    dwarf.put(name, dwarfPhysics);
                }
            }
        }
    }
}
