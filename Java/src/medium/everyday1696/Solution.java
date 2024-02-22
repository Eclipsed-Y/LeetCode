package medium.everyday1696;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     *
     * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
     *
     * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
     *
     * 请你返回你能得到的 最大得分 。
     */
    public int maxResult(int[] nums, int k) {
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{nums[0], 0});
        for (int i = 1; i < nums.length; i++) {
            while (!d.isEmpty() && d.peekFirst()[1] < i - k){
                d.removeFirst();
            }
            if (d.peekFirst() != null) {
                int now = d.peekFirst()[0] + nums[i];
                System.out.println(now + " " + i);
                while (!d.isEmpty() && d.peekLast()[0] <= now){
                    d.removeLast();
                }
                d.addLast(new int[]{now, i});
            }
        }
        if (d.peekLast() != null) {
            return d.peekLast()[0];
        }
        return 0;
    }
}
