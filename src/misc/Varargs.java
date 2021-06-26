package misc;

import java.util.*;

public class Varargs {

    static void printItems(String... items) {
        System.out.println("Items: ");
        for(String item : items)
            System.out.println(item);
        System.out.println();
    }

    public static void main(String[] arg) {

        String item1 = "Bag";
        String item2 = "Ball";
        String item3 = "Bar";
        printItems(item1);
        printItems(item1, item2);
        printItems(item1, item2, item3);
        printItems(new String[] {item1, item2});


    }
}
