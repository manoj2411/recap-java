package collections;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        tmap.put(10, 0);
        tmap.put(5, 0);
        tmap.put(15, 0);
        tmap.put(25, 0);

        // return
        System.out.println(tmap.floorKey(20)); // 15
        System.out.println(tmap.floorKey(2)); // null

        System.out.println(tmap.ceilingKey(2)); // 5
        System.out.println(tmap.floorKey(2)); // null
    }
}
