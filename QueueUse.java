import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueUse {
    public static void main(String [] args) {
        Queue<Integer> q1 = new ArrayBlockingQueue<>(3); //FIFO - First In First Out

        // No Such element exception --- no items in queue yet
//        System.out.println("Head of queue " + q1.element());

        q1.add(10);
        q1.add(20);
        q1.add(30);

        System.out.println("Head of queue " + q1.element());

        try{
        q1.add(40);
        }
        catch (IllegalStateException e){
            System.out.println("Tried to add items more than its size provide");
        }

        for(Integer value : q1){
            System.out.println(value);
        }

        System.out.println("Removed from queue " + q1.remove());
        System.out.println("Removed from queue " + q1.remove());
        System.out.println("Removed from queue " + q1.remove());

        try{
        System.out.println("Removed from queue " + q1.remove());
        }catch (NoSuchElementException e){
            System.out.println("Removed too many items ");
        }

        /////////////////////////////////////////////////////

        Queue<Integer> q2 = new ArrayBlockingQueue<>(2);

        // peek will give element
        System.out.println("Queue2 peek: " + q2.peek()); // null

//        q2.add(10);
//        q2.add(20);
//        q2.add(30); // This will give Exception IllegalStateException: Queue full

        q2.offer(50);
        q2.offer(60);
        // offer will also add items and handle exception if size increase without adding exceeding size item
        if (q2.offer(70) == false) {
            System.out.println("Offer failed to add third item");
        }

        System.out.println("Queue2 peek: " + q2.peek()); // 10

        for(Integer value : q2){
            System.out.println("Queue2 value: " + value);
        }

        // poll will remove elements
        System.out.println("Queue2 poll: " + q2.poll());
        System.out.println("Queue2 poll: " + q2.poll());
        System.out.println("Queue2 poll: " + q2.poll()); // gives null
    }
}
