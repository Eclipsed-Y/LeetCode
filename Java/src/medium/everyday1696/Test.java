package medium.everyday1696;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(1);
        pq.add(6);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());
    }
}
