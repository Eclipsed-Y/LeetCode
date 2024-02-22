package hard._everyday410;

public class Solution {
    /**
     * 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
     * <p>
     * 设计一个算法使得这 k 个子数组各自和的最大值最小。
     */
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] pre = new int[n + 1];
        pre[1] = nums[0];
        dp[0][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i + 1] = nums[i] + pre[i];
            // 共有 i + 1 个，选择前面j个分成l组
            for (int j = 0; j <= i; j++) {
                int tmp = pre[i + 1] - pre[j]; // 后面分为一组
                for (int l = Math.min(j, 1); l <= Math.min(k - 1, j); l++) {  // 前面j个最多分k-1组或者j组
                    dp[i + 1][l + 1] = Math.min(dp[i + 1][l + 1], Math.max(dp[j][l], tmp));
                }
            }
        }
        return dp[n][k];
    }
}
