import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListUse {
    public static void main(String [] args) {
        List<Integer> arrayList = new ArrayList<Integer>();

        List<Integer> linkedList = new LinkedList<Integer>();

        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);

//        System.out.println(arrayList);
    }

    private static void doTimings(String type, List<Integer> list) {
        /*
        * for loop runs 100,000 times (1E5 = 100,000), adding integers sequentially to the list. This tests adding elements at the end of both ArrayList and LinkedList.
        *
        * */
        for(int i=0; i<1E5; i++){
            list.add(i);
        }

        long start = System.currentTimeMillis();

        // Add items elsewhere in list
        for(int i=0; i<1E5; i++){
//            list.add(0,i); // first add
            list.add(list.size()-100, i); // add at end
//            list.add(50, i); // add elsewhere
        }

        long end = System.currentTimeMillis();

        System.out.println("Time Taken: " + (end-start) + "ms for " + type);
    }
}
