import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        // Creating a ConcurrentSkipListMap (Sorted & Thread-safe)
        Map<Integer, String> map = new ConcurrentSkipListMap<>();

        // Adding some initial values
        map.put(3, "Kafka");
        map.put(1, "Java");
        map.put(2, "Spring");

        // Creating two threads to update the map concurrently
        Thread t1 = new Thread(() -> {
            map.put(5, "Microservices");
            System.out.println("Thread 1 updated map: " + map); // Thread 1 updated map: {1=Java, 2=Spring, 3=Kafka, 5=Microservices}, if we wait Thread t2 (Thread.sleep(3000))
        });

        Thread t2 = new Thread(() -> {
            try {
                // Adding 3-second delay
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(4, "Docker");
            System.out.println("Thread 2 updated map: " + map); // Thread 2 updated map: {1=Java, 2=Spring, 3=Kafka, 4=Docker, 5=Microservices}
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to complete
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final map state (Always sorted by key)
        System.out.println("Final Map: " + map); // Final Map: {1=Java, 2=Spring, 3=Kafka, 4=Docker, 5=Microservices}
        System.out.println(map.size()); // 5

    }
}