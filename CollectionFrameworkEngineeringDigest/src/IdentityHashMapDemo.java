import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        // Create an IdentityHashMap
        Map<String, Integer> map = new IdentityHashMap<>();
        String key1 = new String("Akshit");
        String key2 = new String("Akshit");

        map.put(key1, 90);
        map.put(key2, 92);

        /*
         * IdentityHashMap uses reference equality (==) to compare keys,
         * rather than the equals() method or hashCode().
         * Here, key1 and key2 are different objects (created with new String()),
         * so they are treated as distinct keys, even though their content is the same.
         * As a result, both entries are added, and the size of the map becomes 2.
         */
        System.out.println(map); // Output: {Akshit=90, Akshit=92}

        // Create a regular HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        String key3 = new String("Akshit");
        String key4 = new String("Akshit");

        hashMap.put(key3, 90);
        hashMap.put(key4, 92);

        /*
         * HashMap uses content equality (hashCode() and equals()) to compare keys.
         * Since the content of key3 and key4 is the same ("Akshit"), they are treated
         * as the same key. The second put() call replaces the value of the first entry.
         * As a result, the size of the map becomes 1.
         */
        System.out.println(hashMap); // Output: {Akshit=92}
    }
}
