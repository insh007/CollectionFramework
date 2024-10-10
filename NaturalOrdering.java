import java.util.*;

class Per implements Comparable<Per> {
    private String name;

    public Per(String name){
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Per per = (Per) o;
        return Objects.equals(name, per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Per person) {
//        return -name.compareTo(person.name);

        int len1 = name.length();
        int len2 = person.name.length();

        if(len1 > len2) {
            return 1;
        } else if (len1 < len2) {
            return -1;
        }
        else {
//            return 0; // If two different string with same length then only first one is print for TreeSet(behave differently here). On the other hand work fine for Array List.
            return name.compareTo(person.name); // by using this again both string print if they are different but have same length(behave differently here). On the other hand work fine for Array List.
        }
    }
}

public class NaturalOrdering {
    public static void main(String [] args){
//        List<String> list = new ArrayList<>();
        List<Per> list = new ArrayList<>();
//        SortedSet<String> set = new TreeSet<>();
        SortedSet<Per> set = new TreeSet<>(); // Comparable behave differently if two elements length are equal

        addElements(list);
        addElements(set);

        Collections.sort(list);

        showElements(list);
        System.out.println("============================");
        showElements(set);
    }

    public static void addElements(Collection<Per> col) {
        col.add(new Per("Joe"));
        col.add(new Per("Sue"));
        col.add(new Per("Juliet"));
        col.add(new Per("Clare"));
        col.add(new Per("Mike"));
    }

    public static void showElements(Collection<Per> col) {
        for(Per element : col) {
            System.out.println(element);
        }
    }
}
