package Lab12;

import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        String[] names = {
            "Rahul", "Amit", "Rahul",
            "Priya", "Amit", "Neha"
        };

        HashSet<String> set = new HashSet<>();
        LinkedHashSet<String> orderedSet = new LinkedHashSet<>();

        for (String name : names) {
            set.add(name);
            orderedSet.add(name);
        }

        System.out.println("Unique users: " + set.size());

        System.out.println("First three unique users:");

        int count = 0;

        for (String name : orderedSet) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}
