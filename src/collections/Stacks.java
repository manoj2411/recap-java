package collections;
import java.util.*;

public class Stacks {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack();

//        System.out.println("Empty peek: " + s.peek()); // java.util.EmptyStackException
        s.push(10);
        s.push(20);
        s.add(50); // from collections API
        System.out.println("search(10): " + s.search(10));
        System.out.println("search(10): " + s.search(20));
        System.out.println("search(10): " + s.search(50));
        System.out.println("peek: " + s.peek());
        s.pop();
        System.out.println("pop: " + s.pop());
//        System.out.println("Empty pop: " + s.pop()); // EmptyStackException

    }
}
