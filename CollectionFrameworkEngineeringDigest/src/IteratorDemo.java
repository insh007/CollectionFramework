import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(10);

//        for (int i : list) {
//            System.out.println(i); // 4, 3, 10
//        }

        // internally for each loop uses Iterator
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next()); // 4, 3, 10
//        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

//        for (Integer number : numbers) {
//            if (number % 2 == 0) {
//                numbers.remove(number); // Give Exception because we can't perform write operation at the same time during read operation
//            }
//        }

        Iterator<Integer> itr = numbers.iterator(); // can perform read and write operation simultaneously
        while (itr.hasNext()) {
            Integer number = itr.next();
            if (number % 2 == 0) {
                itr.remove();
            }
        }
        System.out.println("Modified list" + numbers);

    }
}