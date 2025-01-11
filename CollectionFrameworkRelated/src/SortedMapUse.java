import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedMapUse {
    public static void main(String [] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

//        testMap(hashMap);
//        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(3, "Lion");
        map.put(5, "Snake");
        map.put(2, "Tiger");
        map.put(4, "Animal");
        map.put(1, "Goat");

        for(Integer key : map.keySet()) {
            String value = map.get(key);

            System.out.println(key + ":" + value);
        }
    }
}
