package medium._everyday2866;

import java.util.List;
import java.util.Map;
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
        Stack<Integer> stack = new Stack<>();
        long[] pre = new long[n];
        long[] suf = new long[n];
        for (int i = 0; i < n; i++) {
            while(!stack.empty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                stack.pop();
            }
            if(stack.empty()){
                pre[i] = (long) maxHeights.get(i) * (i + 1);
            } else {
                pre[i] = ((long) maxHeights.get(i) * (i - stack.peek())) + pre[stack.peek()];
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--){
            while(!stack.empty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                stack.pop();
            }
            if(stack.empty()){
                suf[i] = (long) maxHeights.get(i) * (n - i);
            } else {
                suf[i] = ((long) maxHeights.get(i) * (stack.peek() - i)) + suf[stack.peek()];
            }
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, pre[i] + suf[i] - maxHeights.get(i));
        }
        return res;
    }
}
