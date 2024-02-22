package medium.everyday2865;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
     *
     * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
     *
     * 如果以下条件满足，我们称这些塔是 美丽 的：
     *
     * 1 <= heights[i] <= maxHeights[i]
     * heights 是一个 山脉 数组。
     * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
     *
     * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
     * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
     * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        Stack<Integer> s = new Stack<>();
        long[] pre = new long[n], sub = new long[n];
        pre[0] = maxHeights.get(0);
        sub[n - 1] = maxHeights.get(n - 1);
        long ans = 0;
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.empty() && maxHeights.get(s.peek()) > maxHeights.get(i)){
                s.pop();
            }
            if (!s.empty()){
                pre[i] = pre[s.peek()] + (long) maxHeights.get(i) * (i - s.peek());
            } else {
                pre[i] = (long) maxHeights.get(i) * (i+1);
            }
            s.push(i);
        }
        s.clear();
        s.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!s.empty() && maxHeights.get(s.peek()) > maxHeights.get(i)){
                s.pop();
            }
            if (!s.empty()){
                sub[i] = sub[s.peek()] + (long) maxHeights.get(i) * (s.peek() - i);
            } else {
                sub[i] = (long) maxHeights.get(i) * (n - i);
            }
            s.push(i);
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(sub));
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pre[i] + sub[i] - (long) maxHeights.get(i));
        }
        return ans;
    }
}
