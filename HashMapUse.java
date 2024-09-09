import java.util.HashMap;
import java.util.Map;

public class HashMapUse {
    public static void main(String [] args) {
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
//        HashMap<Integer, String> map = new HashMap<>();
        // Below is working because HashMap is implementing Map Interface
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println(map.get(2));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();

            System.out.println("Key " + key + " Value " + value);
        }
    }
}
