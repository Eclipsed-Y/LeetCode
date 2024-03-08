package easy.everyday232;

import java.util.Stack;

public class MyQueue {
    Stack<Integer>s1, s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        int ans = pop();
        s2.push(ans);
        return ans;
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
