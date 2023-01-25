import java.util.*;

public class HashMapBasics {
    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Divyajyoti", 100);
        map.put("Avichal", 200);
        map.put("Deepteshjyoti", 300);

        System.out.println("The Map Size: " + map.size());
        // Map is key,value Pair Data structure

        System.out.println(map);

        if (map.containsKey("Divyajyoti")) {
            int value = map.get("Divyajyoti"); // Access value of any key.
            System.out.println("Value: " + value);
        }

        map.remove("Avichal");

        // Traverse Hashmap
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }
}

// Notes:
/*
 * Hashmap is similar to hashtable. But it asynchronized.
 * Hashmap is a part of java collections which are the implementation of Map
 * interface of Java.
 * It stores the data in (Key,Value) pair
 * Key must be unique. which is basically used for indexing the element in Map.
 * Only one null key allowed but multiple null values are allowed.
 * 
 * Hashing: is a technique of converting a large string to small string that
 * represent the same string.
 * A shorter value helps in indexing and faster searches.
 */