import java.util.ArrayList;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) throws InterruptedException {
        // Note: ArrayList is not a Thread safe. Same resource data which is
        // sharing across multiple threads like below will be corrupt. we are excepting list size 2000,
        // but it is changes and data will not consist of 2000. That's why it is not follow Thread safety.
//        ArrayList<Integer> list = new ArrayList<>();

        Vector<Integer> list = new Vector<>(); // Thread-safe

        Thread t1 = new Thread(() -> {
           for (int i =1; i<=1000; i++){
               list.add(i);
           }
        });

        Thread t2 = new Thread(() -> {
           for(int i=1; i<=1000; i++){
               list.add(i);
           }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Size of list: " + list.size()); // Output: 2000


        // Vector<Integer> list = new Vector<>(5, 3);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        System.out.println(list.capacity());
//        list.add(1);
//        System.out.println(list.capacity());
//        list.add(1);
//        list.add(1);
//        System.out.println(list.capacity());
//        list.add(1);
//        System.out.println(list.capacity());
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        Vector<Integer> vector1 = new Vector<>(linkedList);
//        System.out.println(vector1);
//        for(int i = 0; i < vector1.size(); i++){
//            System.out.println(vector1.get(i));
//        }
//        vector1.clear();
//        System.out.println(vector1);

    }
}
