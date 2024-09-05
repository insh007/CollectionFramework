import java.util.ArrayList;

public class ArrayListUse {
    public static void main(String [] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        ArrayList<Integer> numbers = new ArrayList<>(); // This will work, added Note below.

        //Note : Type argument cannot be of primitive type
        /*
        * The following line of code is invalid in Java:
        *   ArrayList<int> numbers = new ArrayList<int>(); // This is wrong
        * This is because Java's generics only work with reference types, not primitive types.
        * Here, Integer is the wrapper class for the primitive type int. Java's ArrayList (and all other generic types) can only accept reference types like Integer, String, etc.
        * */

        // Adding elements
        numbers.add(10);
        numbers.add(50);
        numbers.add(100);

        // Retrieving
        System.out.println(numbers.get(1));

        System.out.println("\nIteration #1 using traditional for loop");
        for (int i=0; i<numbers.size(); i++){
            System.out.println(numbers.get(i));
        }

        // Note - Remove item carefully
        // Removing last item
        numbers.remove(numbers.size()-1);

        // Removing first item (First element remove is very slow)
        numbers.remove(0);

        System.out.println("\nIteration #2 using for each loop");
        for(int values : numbers){
            System.out.println(values);
        }

//        Note:
        /*
        * 1. ArrayList<Integer> numbers = new ArrayList<Integer>();
            This is the traditional way of instantiating a generic ArrayList. In this form, both the declaration and the instantiation explicitly specify the type parameter (Integer in this case). This syntax is valid in all versions of Java that support generics (Java 5+).
        *
        * 2. ArrayList<Integer> numbers = new ArrayList<>();
            This is a shorthand introduced in Java 7 through a feature called "diamond operator" (<>). The diamond operator allows the compiler to infer the type parameters from the variable's declaration on the left side (ArrayList<Integer>), so you don't need to specify the type again on the right side. This makes the code cleaner and avoids redundancy, but it provides the same result as the first example.
        * */
    }
}
