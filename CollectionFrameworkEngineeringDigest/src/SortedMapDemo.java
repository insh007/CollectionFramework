import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>(); // natural sorting because comparator = null
//        Map<Integer, String> map = new TreeMap<>((a, b) -> b - a); // Descending order, by using the comparator with lamda expression in argument
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");
        map.get(77);
        map.containsKey(78);
        map.containsValue(77);
        System.out.println(map);

        // when you use the interface SortedMap then we can use the below methods firstKey, lastKey, headMap, tailMap
        System.out.println("--------SortedMap--------");
        SortedMap<Integer, String> map1 = new TreeMap<>((a, b) -> b - a);
        map1.put(91, "Vivek");
        map1.put(99, "Shubham");
        map1.put(100, "Inshad");
        map1.put(78, "Mohit");
        map1.put(77, "Vipul");
        System.out.println(map1); // {100=Inshad, 99=Shubham, 91=Vivek, 78=Mohit, 77=Vipul}
        System.out.println(map1.firstKey()); // 99
        System.out.println(map1.lastKey()); // 77
        System.out.println(map1.headMap(91)); // {100=Inshad, 99=Shubham}, it will exclude entries from 91(Passing key) to below level keys
        System.out.println(map1.tailMap(91)); // {91=Vivek, 78=Mohit, 77=Vipul}, it will include entries from 91(Passing key) to below level keys

        System.out.println("----------NavigableMap------------");
        // when you use the interface SortedMap then we can use the below methods lowerKey, ceilingKey, higherEntry, descendingMap
        NavigableMap<Integer, String> navigableMap =  new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        System.out.println(navigableMap); // {1=One, 3=Three, 5=Five}
        System.out.println(navigableMap.lowerKey(4)); // 3,  Returns the lower key less than the given key, or null if there is no such key
        System.out.println(navigableMap.ceilingKey(3)); // 3,  Returns the least key greater than or equal to the given key, or null if there is no such key.
        System.out.println(navigableMap.higherEntry(1)); // 3=Three, Returns the key value pair greater than the given key or null if there is no such key.
        System.out.println(navigableMap.descendingMap()); // {5=Five, 3=Three, 1=One}
    }
}