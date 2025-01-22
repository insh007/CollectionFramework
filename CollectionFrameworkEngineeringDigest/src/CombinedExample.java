import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Stud implements Comparable<Stud>  {
    int id;
    String name;

    public Stud(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Define natural ordering based on ID
    @Override
    public int compareTo(Stud other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Stud{id=" + id + ", name='" + name + "'}";
    }
}

// Alphabetical sorting
class NameBasedComparator implements Comparator<Stud> {
    @Override
    public int compare(Stud s1, Stud s2) {
        return s1.name.compareTo(s2.name); // Sort by name alphabetically
    }
}

public class CombinedExample {
    public static void main(String[] args) {
        ArrayList<Stud> students = new ArrayList<>();
        students.add(new Stud(3, "Alice"));
        students.add(new Stud(1, "Bob"));
        students.add(new Stud(2, "Charlie"));

        // Natural order (by ID)
//        Collections.sort(students); // Sort based on compareTo() of Comparable interface
        // OR- students.sort(null);
//        System.out.println(students); // [Stud{id=1, name='Bob'}, Stud{id=2, name='Charlie'}, Stud{id=3, name='Alice'}]

        // Custom order (by name) using Comparator
//        Collections.sort(students, new NameBasedComparator());
        // OR- students.sort(new NameBasedComparator());

//        System.out.println(students); // [Stud{id=3, name='Alice'}, Stud{id=1, name='Bob'}, Stud{id=2, name='Charlie'}]

        // Combined sorting (by name, then by ID)
        students.sort(Comparator.comparing((Stud s) -> s.name).thenComparingInt(s -> s.id));
        System.out.println("Sorted by name, then by ID: " + students);
    }
}
