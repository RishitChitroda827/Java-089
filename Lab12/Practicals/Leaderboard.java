package Lab12;

import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Rahul", 90);
        scores.put("Amit", 85);
        scores.put("Priya", 95);
        scores.put("Neha", 90);

        List<String> players =
            new ArrayList<>(scores.keySet());

        Collections.sort(players, new Comparator<String>() {
            public int compare(String a, String b) {

                if (scores.get(a).equals(scores.get(b))) {
                    return a.compareTo(b);
                }

                return scores.get(b) - scores.get(a);
            }
        });

        System.out.println("Top 3 Players:");

        for (int i = 0; i < 3; i++) {
            String name = players.get(i);

            System.out.println(
                name + " : " + scores.get(name));
        }
    }
}
