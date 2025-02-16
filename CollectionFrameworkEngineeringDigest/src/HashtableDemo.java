import java.util.Hashtable;
import java.util.Map;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        // Hashtable is synchronized
        // no null key or value
        // Legacy Class, ConcurrentHashMap is prefer
        // slower than HashMap
        // only linked list in case of collision
        //  all methods are synchronized
        hashtable.put(1, "Apple");
        hashtable.put(2, "Banana");
        hashtable.put(3, "Cherry");
        System.out.println(hashtable); // {3=Cherry, 2=Banana, 1=Apple}
        System.out.println("Value for key 2: " + hashtable.get(2)); // Value for key 2: Banana
        System.out.println("Does key 3 exist? " + hashtable.containsKey(3)); // Does key 3 exist? true
        hashtable.remove(1);
        System.out.println("After removing key 1: " + hashtable); // // Value for key 2: Banana
//        hashtable.put(null, "value"); // Throws exception
        hashtable.put(4, null);   // Throws exception


        Map<Integer, String> map = new Hashtable<>();
//        Map<Integer, String> map = new HashMap<>(); // size vary
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread2");
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final size of HashMap: " + map.size()); // Final size of HashMap: 2000

    }
}