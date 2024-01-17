package hard.everyday1944;

public class Solution {
    /**
     * 有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
     *
     * 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
     *
     * 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
     */
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        int[] last = new int[n];
        last[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if(heights[i] <= heights[i + 1]){
                ans[i] = 1;
                last[i] = i + 1;
            } else {
                int num = 1;
                int pre = i + 1;
                int tmp = last[i + 1];
                while (tmp < n - 1 && heights[tmp] < heights[i] && heights[pre] < heights[tmp]){
                    num += 1;
                    pre = tmp;
                    tmp = last[tmp];
                }
                if (heights[pre] < heights[tmp]){
                    num += 1;
                    last[i] = tmp;
                } else {
                    last[i] = pre;
                }
                ans[i] = num;
            }
        }
        return ans;
    }
}
