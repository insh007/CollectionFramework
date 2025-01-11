import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UsingIterators {
    public static void main(String[] args) {
        List<String> animals = new LinkedList<>();
        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        Iterator<String> values = animals.iterator();
        while (values.hasNext()){
            String value = values.next();
            System.out.println(value);

            if (value.equals("cat")){
                values.remove();
            }
        }

        System.out.println("///////////////////////////////////");

        // Modern iteration, Java 5 and later
        for (String animal : animals){
            System.out.println(animal);
        }

    }

}
