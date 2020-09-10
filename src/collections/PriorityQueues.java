// package collections;

import java.util.*;


public class PriorityQueues {

    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(2);
        minHeap.add(1);
        minHeap.add(-1);
        System.out.println("peek: " + minHeap.peek());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(-1);
        System.out.println("peek: " + maxHeap.peek());


    }
}
