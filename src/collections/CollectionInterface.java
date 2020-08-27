package collections;

import java.util.*;

public class CollectionInterface {

    public static void main(String[] args) {
        List aList = new ArrayList();
        aList.add("hey there!");
        aList.add(24);

        String[] chars = {"A", "B", "C", "A"};

        System.out.println(aList);

        // common methods of list interface
        //
        aList.add(true);
        aList.addAll(Arrays.asList(chars));

        System.out.println(aList.contains(24));
        System.out.println(aList.containsAll(Arrays.asList(chars)));

        System.out.println(aList.remove("A") );
        // aList.removeAll(Collection c)
        // aList.retainAll(Collection c)
        aList.clear();

        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        // HashSet
        Set s1 = new HashSet();
        s1.add("Zara");
        s1.add("Mahnaz");
        s1.add("Ayan");
        System.out.println();
        System.out.println(" Set Elements");
        System.out.print("\t" + s1);

        // HashMap
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);

    }
}

