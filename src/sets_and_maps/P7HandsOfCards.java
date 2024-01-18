package sets_and_maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P7HandsOfCards {

    // (S -> 4, H-> 3, D -> 2, C -> 1)
    static Map<String, Integer> types = Map.of("S", 4,
                                               "H", 3,
                                               "D", 2,
                                               "C", 1);
    // P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A)
    // Powers 2 to 10 have the same value, and J to A is 11 to 14.
    static Map<String, Integer> power = new HashMap<>(Map.of("2", 2,
                                                             "3", 3,
                                                             "4", 4,
                                                             "5", 5,
                                                             "6", 6,
                                                             "7", 7,
                                                             "8", 8,
                                                             "9", 9,
                                                             "10", 10,
                                                             "J", 11
                                                            ));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        power.put("Q", 12);
        power.put("K", 13);
        power.put("A", 14);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String playerName = tokens[0];
            //            if (!players.containsKey(playerName)){
            //                players.put(playerName, new HashSet<>());
            //            }
            players.putIfAbsent(playerName, new HashSet<>());

            Arrays.stream(tokens[1].split(", "))
                  .forEach(players.get(playerName)::add);

            input = scanner.nextLine();
        }

        players.forEach((player, cards) -> {
            int points = calculatePoints(cards);
            System.out.printf("%s: %d\n", player, points);
        });

    }

    private static int calculatePoints(Set<String> cards) {
        int points = 0;
        for (String card : cards) {
            String cardPower = card.substring(0, card.length() - 1);
            String type = String.valueOf(card.charAt(card.length() - 1));

            points += power.get(cardPower) * types.get(type);
        }
        return points;
    }
}
