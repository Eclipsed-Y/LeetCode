package medium.everyday82;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode();
        ListNode p = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (p != null) {
            if (map.containsKey(p.val)) {
                map.put(p.val, map.get(p.val) + 1);
            } else {
                map.put(p.val, 1);
            }
            p = p.next;
        }
        p = ans;

        while (head != null) {
            if (map.get(head.val) == 1) {
                p.next = new ListNode(head.val);
                p = p.next;
            }
            head = head.next;
        }
        return ans.next;
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
