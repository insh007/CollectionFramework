import java.lang.ref.WeakReference;

public class GarbageCollection {
    public static void main(String[] args) {
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple", "16 pro max"));
        System.out.println(phoneWeakReference.get());
        System.gc(); // Suggested to JMV for remove the weak reference
        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {
        }
        System.out.println(phoneWeakReference.get()); // null, it will Garbage collected(remove) by the JVM


        // new Phone("Apple", "16 pro max"), this is not assigned in a variable so this is also an example of weak reference
    }
}

class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}