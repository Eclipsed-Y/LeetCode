package easy.everyday225;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()){
            while (q2.size() > 1){
                q1.add(q2.poll());
            }
            return q2.poll();
        }
        while (q1.size() > 1){
            q2.add(q1.poll());
        }
        return q1.poll();
    }

    public int top() {
        int ans = pop();
        push(ans);
        return ans;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
