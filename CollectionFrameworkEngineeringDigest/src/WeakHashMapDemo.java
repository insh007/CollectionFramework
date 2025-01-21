import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        loadCache(imageCache);
        System.out.println(imageCache); // {img1=Image 1, img2=Image 2}
        System.gc(); // Suggested to JMV for remove the weak reference like k1 & k2 because these are unknown for the main method
        simulateApplicationRunning(); // simulating some work
        System.out.println("Cache after running (some entries may be cleared): " + imageCache); // {}
    }

    public static void loadCache(Map<String, Image> imageCache) {
        /* Note:
           k1 and k2 scope is only in method loadCache, so these are weak reference for main method
           and in WeakHashMap when the key is weak referenced then it will remove by JVM as part of
           Garbage Collection.
         */
        String k1 = new String("img1");
        String k2 = new String("img2");
        imageCache.put(k1, new Image("Image 1"));
        imageCache.put(k2, new Image("Image 2"));

        // OR
        // we can directly pass new String("img1"), this is also weak reference
//        imageCache.put(new String("img1"), new Image("Image 1"));
//        imageCache.put(new String("img2"), new Image("Image 2"));
    }


    private static void simulateApplicationRunning() {
        try {
            System.out.println("Simulating application running...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}