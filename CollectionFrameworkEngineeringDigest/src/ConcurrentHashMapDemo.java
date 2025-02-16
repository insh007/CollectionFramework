import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
//        Map<String, Integer> map =  new ConcurrentHashMap<>();
        // Java 7 --> segment based locking --> 16 segments --> smaller hashmaps
        // Only the segment being written to or read from is locked
        // read: do not require locking unless there is a write operation happening on the same segment
        // write: lock

        // java 8 --> no segmentation
        //        --> Compare-And-Swap approach --> no locking except resizing or collision
        // Thread A last saw --> x = 45
        // Thread A work --> x to 50
        // if x is still 45, then change it to 50 else don't change and retry
        // put --> index

        // MAP --> SORTED --> THREAD SAFE --> ConcurrentSkipListMap

        Map<Integer, String> map = new ConcurrentHashMap<>();
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