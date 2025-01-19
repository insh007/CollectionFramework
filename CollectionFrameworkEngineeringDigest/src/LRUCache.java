import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    //Note: LRUCache extends LinkedHashMap with accessOrder = true
    // (third argument to the LinkedHashMap constructor). This ensures the
    // map maintains the entries in the order of access (not just insertion order).
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // invoke LinkedHashMap constructor
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // this method will invoke automatically when put method called and remove the eldest(from starting insertion order) entry
    }

    public static void main(String[] args) {
        //Note: The cache has a maximum capacity of 3. When more entries are added,
        // the least recently used (LRU) entry is removed to maintain this limit.
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
        studentMap.put("Bob", 100);
        studentMap.put("Vipul", 89);

        System.out.println("Output is :");
        System.out.println(studentMap);

        /*
        Output is :
        {Ram=91, Bob=100, Vipul=89}
        */
    }
}