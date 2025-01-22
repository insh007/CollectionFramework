import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class St {
    int id;
    String name;

    public St(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "St{id=" + id + ", name='" + name + "'}";
    }
}

// Separate class for sorting by name and then by ID
class NameThenIdComparator implements Comparator<St> {
    @Override
    public int compare(St s1, St s2) {
        // First compare by name
        int nameComparison = s1.name.compareTo(s2.name);

        // If names are equal, compare by id
        if (nameComparison == 0) {
            return Integer.compare(s1.id, s2.id);
        }

        // Otherwise, return the result of name comparison
        return nameComparison;
    }
}

public class SortByNameThenIdExample {
    public static void main(String[] args) {
        ArrayList<St> students = new ArrayList<>();
        students.add(new St(3, "Charlie"));
        students.add(new St(1, "Alice"));
        students.add(new St(2, "Alice"));
        students.add(new St(4, "Bob"));

        // Sort using the custom comparator (NameThenIdComparator)
        Collections.sort(students, new NameThenIdComparator());

        // Output the sorted list
        System.out.println(students);
        // Output: [St{id=1, name='Alice'}, St{id=2, name='Alice'}, St{id=4, name='Bob'}, St{id=3, name='Charlie'}]
    }
}
