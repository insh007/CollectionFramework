import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1);

        map.put(p1, "Engineer"); // hashcode1 --> index1
        map.put(p2, "Designer"); // hashcode2 --> index2
        map.put(p3, "Manager"); // hashcode1 --> index1 --> equals --> replace

        // Note: If hashCode and equals method is not present in custom class then it will add the p3 "Alice" in
        // memory and the size of map becomes 3 instead of 2 that is wrong because that is not the behaviour of map, p1 & p3 is
        // same (keys should be unique) so we need to add hashCode and equals method in our custom classes.
        System.out.println("HashMap Size: " + map.size()); // 2
        System.out.println("Value for p1: " + map.get(p1)); // Manager
        System.out.println("Value for p3: " + map.get(p3)); // Manager


        // Note: In String class, hashCode and equals method is present by default in the java class that's why it is working
        // fine here. we don't need to create explicitly.
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 90); // hashcode1 --> index1
        map1.put("Neha", 92); // hashcode2 --> index2
        map1.put("Shubham", 99); // hashcode1 --> index1 --> equals() --> replace

    }

}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }

}