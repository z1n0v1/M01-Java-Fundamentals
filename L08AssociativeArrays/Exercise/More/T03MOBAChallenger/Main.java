/*
    https://judge.softuni.org/Contests/Practice/Index/1313#2

    03. MOBA Challenger

Pesho is a pro MOBA player, he is struggling to become master of the Challenger tier.
So he watches carefully the statistics in the tier.
You will receive several input lines in one of the following formats:
"{player} -> {position} -> {skill}"
"{player} vs {player}"
The player and position are strings, the given skill will be an integer number. You need to keep track of every player.
When you receive a player and his position and skill, add him to the player pool, if he isn't present,
else add his position and skill or update his skill, only if the current position skill is lower than the new value.
If you receive "{player} vs {player}" and both players exist in the tier, they duel with the following rules:
Compare their positions, if they got at least one in common, the player with better total skill points wins
and the other is demoted from the tier -> remove him. If they have same total skill points,
the duel is tie and they both continue in the Season.
If they don't have positions in common, the duel isn't happening and both continue in the Season.
You should end your program when you receive the command "Season end". At that point you should print the players,
ordered by total skill in desecending order, then ordered by player name in ascending order.
Foreach player print their position and skill, ordered desecending by skill, then ordered by position name in ascending order.

Input / Constraints
•	The input comes in the form of commands in one of the formats specified above
•	Player and position will always be one word string, containing no whitespaces
•	Skill will be an integer in the range [0, 1000]
•	There will be no invalid input lines
•	The program ends when you receive the command "Season end"

Output
•	The output format for each player is:
"{player}: {totalSkill} skill"
"- {position} <::> {skill}"
 */

package L08AssociativeArrays.Exercise.More.T03MOBAChallenger;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static LinkedHashMap<String, LinkedHashMap<String, Integer>> players;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        players = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Season end")) {

            if (input.contains("->")) {
                String[] data = input.split(" -> ");
                String player = data[0], position = data[1];
                int skill = Integer.parseInt(data[2]);

                updatePlayer(player, position, skill);
            } else {
                String[] data = input.split(" vs ");
                playerVSPlayer(data[0], data[1]);
            }
            input = scanner.nextLine();
        }

        LinkedHashMap<String, Integer> playersTotalSkill = new LinkedHashMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Integer>> player : players.entrySet()) {
            int playerTotalScore = playerTotalSkill(player.getKey());
            playersTotalSkill.put(player.getKey(), playerTotalScore);
        }

        playersTotalSkill.entrySet().stream().sorted((a, b) -> {
                    if (a.getValue().equals(b.getValue())) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return b.getValue().compareTo(a.getValue());
                })
                .forEach(player -> {
                    System.out.printf("%s: %d skill%n", player.getKey(), player.getValue());
                    players.get(player.getKey()).entrySet().stream().sorted((a, b) -> {
                        if (a.getValue().equals(b.getValue())) {
                            return a.getKey().compareTo(b.getKey());
                        }
                        return b.getValue().compareTo(a.getValue());
                    }).forEach(position -> System.out.printf("- %s <::> %d%n", position.getKey(), position.getValue()));
                });

    }

    private static void playerVSPlayer(String player1, String player2) {
        if (hasCommonPosition(player1, player2)) {
            int contestResult = playerTotalSkill(player1) - playerTotalSkill(player2);

            if (players.containsKey(player1) && players.containsKey(player2)) {
                if (contestResult > 0) {
                    players.remove(player2);
                } else if (contestResult < 0)
                    players.remove(player1);
            }
        }
    }

    private static boolean hasCommonPosition(String player1, String player2) {
        LinkedHashMap<String, Integer> player1Positions = players.get(player1);
        LinkedHashMap<String, Integer> player2Positions = players.get(player2);

        if(player1Positions != null && player2Positions != null) {
            for (Map.Entry<String, Integer> position1 : player1Positions.entrySet()) {
                for (Map.Entry<String, Integer> position2 : player2Positions.entrySet()) {
                    if (position1.getKey().equals(position2.getKey()))
                        return true;
                }
            }
        }
        return false;
    }

    private static int playerTotalSkill(String player) {
        int totalSkillPoints = 0;
        LinkedHashMap<String, Integer> playerPositions = players.get(player);

        for (Map.Entry<String, Integer> position : playerPositions.entrySet())
            totalSkillPoints += position.getValue();
        return totalSkillPoints;
    }

    private static void updatePlayer(String player, String position, int skill) {
        if (!players.containsKey(player)) {
            LinkedHashMap<String, Integer> positions = new LinkedHashMap<>();
            positions.put(position, skill);
            players.put(player, positions);
        } else {
            if (!players.get(player).containsKey(position)) {
                players.get(player).put(position, skill);
            } else {
                if (players.get(player).get(position) < skill) {
                    players.get(player).put(position, skill);
                }
            }
        }
    }
}
