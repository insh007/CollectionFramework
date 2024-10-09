import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLenghtComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 > length2) {
            return 1;
        } else if (length1 < length2) {
            return -1;
        }
        return 0; // length1 == length2
    }
}

class AlphabeticalComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}

class ReverseAlphabeticalComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
//        return s1.compareTo(s2); // if s1 > s2 then return +1;
        return -s1.compareTo(s2);   // if s1 < s2 then return -1;
    }
}

class Personn {
    private int id;
    private String name;

    public Personn( int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
//        return "Personn{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//        return "id " + id;
        return name;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class SortingList {
    public static void main(String[] args) {
        ////////////// Sorting Strings ////////////////////
        List<String> animals = new ArrayList<>();

        animals.add("tiger");
        animals.add("lion");
        animals.add("cat");
        animals.add("snake");
        animals.add("mongoose");
        animals.add("elephant");

//        Collections.sort(animals); // Natural Order sort
//        Collections.sort(animals, new StringLenghtComparator()); // Custom sort based on Length

//        Collections.sort(animals, new AlphabeticalComparator()); // Natural Order sort
        Collections.sort(animals, new ReverseAlphabeticalComparator()); // Reverse sort

        for(String animal : animals) {
            System.out.println(animal);
        }

        ////////////// Sorting Numbers ////////////////////
        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(4);
        numbers.add(33);
        numbers.add(12);
        numbers.add(50);
        numbers.add(1);

//        Collections.sort(numbers); // Natural Order Sort

        // Anonymous class
        // we can directly pass in argument as anonymous class instead creating separately
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return -num1.compareTo(num2);
            }
        });

        for(int number : numbers) {
            System.out.println(number);
        }

        ////////////// Sorting arbitary objects ////////////////////

        List<Personn> person = new ArrayList<>();

        person.add(new Personn(1, "Joe"));
        person.add(new Personn(3, "Bob"));
        person.add(new Personn(4, "Clare"));
        person.add(new Personn(2, "Sue"));

        // sort in order of id
        Collections.sort(person, new Comparator<Personn>() {
            @Override
            public int compare(Personn p1, Personn p2) {
                if(p1.getId() > p2.getId()) {
                    return 1;
                } else if (p1.getId() < p2.getId()) {
                    return -1;
                }
                return 0;
            }
        });

        // sort in order of name
        Collections.sort(person, new Comparator<Personn>() {
            @Override
            public int compare(Personn p1, Personn p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        for(Personn p : person) {
            System.out.println(p);
        }
    }
}
