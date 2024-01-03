package medium.everyday2487;

import java.util.Stack;

public class Solution {
    /**
     * 给你一个链表的头节点 head 。
     * <p>
     * 移除每个右侧有一个更大数值的节点。
     * <p>
     * 返回修改后链表的头节点 head 。
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNodes(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while (p!= null){
            while (!s.isEmpty() && s.peek() < p.val){
                s.pop();
            }
            s.push(p.val);
            p = p.next;
        }
        ListNode h = new ListNode();
        p = h;
        for (int i = 0; i < s.size(); i++) {
            p.next = new ListNode(s.get(i));
            p = p.next;
        }
        return h.next;
    }
}
