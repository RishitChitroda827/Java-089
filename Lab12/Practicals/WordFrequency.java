package Lab12;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String text = "java is easy java is useful java";

        String[] words = text.split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                return map.get(b) - map.get(a);
            }
        });

        for (String word : list) {
            System.out.println(word + " : " + map.get(word));
        }
    }
}
