import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Students {
    int id;
    String name;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{id=" + id + ", name='" + name + "'}";
    }
}

// Alphabetical sorting
class NameComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.name.compareTo(s2.name); // Sort by name alphabetically
    }
}

// Integer Based sorting
class IdBasedComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
//        if(o1.id > o2.id) {
//            return 1;
//        }
//        if(o1.id < o2.id) {
//            return -1;
//        }
//        return 0;

        // Modern Approach
        return Integer.compare(o1.id, o2.id); // Compare IDs directly
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Students> students = new ArrayList<>();
        students.add(new Students(3, "Bob"));
        students.add(new Students(1, "Charlie"));
        students.add(new Students(2, "Alice"));

        // Sort by name using Comparator
        Collections.sort(students, new NameComparator()); // By creating custom class

        // Using Lamda Expression
        //students.sort((s1, s2) -> s1.name.compareTo(s2.name));

        // Using Comparator Utility Methods:
        //students.sort(Comparator.comparing(student -> student.name));
        System.out.println(students); // Output: [Students{id=2, name='Alice'}, Students{id=3, name='Bob'}, Students{id=1, name='Charlie'}]

        // Sort by id using Comparator
         Collections.sort(students, new IdBasedComparator()); // By creating custom class

        // Using Lamda Expression
        //students.sort((s1, s2) -> Integer.compare(s1.id, s2.id));

        // Using Comparator Utility Methods:
        //students.sort(Comparator.comparingInt(student -> student.id));
        System.out.println(students); // Output: [Students{id=1, name='Charlie'}, Students{id=2, name='Alice'}, Students{id=3, name='Bob'}]
    }
}
/*
What is Comparator?
   The Comparator interface is used to define a custom ordering for objects. You can implement this interface
   in a separate class or as a lambda/anonymous class.

  Key Points:
  1. It's part of java.util package.
  2. You must implement the compare() method.
  3. Used when you need multiple ways to compare objects (e.g., sorting by name, age, etc.).

  When to Use:
  1. Use Comparator when you need flexible/custom sorting and don’t want to modify the class itself.
  2. When you need multiple sorting logics.
     Example: Sorting students by name, then by age, then by grade.

 */
