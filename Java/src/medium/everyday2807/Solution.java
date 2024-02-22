package medium.everyday2807;

import java.util.ArrayList;

public class Solution {
    /**
     * 给你一个链表的头 head ，每个结点包含一个整数值。
     * <p>
     * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
     * <p>
     * 请你返回插入之后的链表。
     * <p>
     * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ArrayList<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>();
        while (head != null) {
            if (head.next != null){
                arr2.add(find(head.val, head.next.val));
            }
            arr1.add(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(arr1.get(0));
        ListNode cur = res;
        for (int i = 0; i < arr2.size(); i++) {
            cur.next = new ListNode(arr2.get(i));
            cur = cur.next;
            cur.next = new ListNode(arr1.get(i + 1));
            cur = cur.next;
        }
        return res;
    }

    public int find(int a, int b) {
        int res = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                res = i;
            }
        }
        return res;
    }


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

}
