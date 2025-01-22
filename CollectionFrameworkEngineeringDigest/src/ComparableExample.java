import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>  {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Define natural ordering based on ID
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(3, "Alice"));
        students.add(new Student(1, "Bob"));
        students.add(new Student(2, "Charlie"));

        Collections.sort(students); // Sort based on compareTo()

        System.out.println(students); // Output: [Student{id=1, name='Bob'}, Student{id=2, name='Charlie'}, Student{id=3, name='Alice'}]

        // ======================================================
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(10);
        list.sort(null);
        System.out.println(list); // Output: [3, 5, 10]
        /*
        Explanation of sort(null):
        1. The sort(null) method uses the natural ordering of elements to sort the list.
        2. For objects to have a natural order, the class must implement the Comparable interface.
        3. In your first example (ArrayList<Integer>), the Integer class implements Comparable<Integer>,
           which is why it works fine.
        4. In your Student class example, you have implemented Comparable<Student>, so the natural
           ordering is defined, but the ClassCastException occurs because the list or elements in the list
           are not recognized as Comparable during runtime.

           Note:
           1. In the case of Integer, the class is part of Java's core library and is final,
              meaning you cannot subclass it.
           2. Every instance of Integer is guaranteed to implement Comparable.
        */
    }
}

/*
What is Comparable?
   The Comparable interface is used to define the natural ordering of objects. It provides a single method,
   compareTo(), which allows objects of the same type to be compared.

Key Points:
1. It's part of java.lang package.
2. You must implement the compareTo() method in the class itself.
3. Used when you want a default sorting order for objects.

When to Use:
1. Use Comparable when the class itself should define the sorting logic (natural ordering).
   Example: Sorting strings alphabetically, sorting numbers numerically.
2. If there's a single, natural way to sort objects.
   Example: Sorting employees by ID, sorting products by price.
 */
