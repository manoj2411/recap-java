package generics;

import java.util.*;

public class GenericMethod {

    // Add new Type param before the return type of the method
    public static <A> List<A> arrToList(A[] arr) {
        List<A> list = new ArrayList<>();
        for(A obj : arr)
            list.add(obj);

        return list;
    }

    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4};
        Character[] chars = {'a', 'b', 'c'};

        List<Integer> intList = arrToList(ints);
        List<Character> charList = arrToList(chars);

        System.out.println(intList);
        System.out.println(charList);
    }
}
