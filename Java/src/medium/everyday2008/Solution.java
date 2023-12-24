package medium.everyday2008;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /*
        你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。

乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。

每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。

给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。

注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。
     */
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int right = -1, left = 0;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while(right + 1 < rides.length && rides[right + 1][1] <= i){
                right += 1;
            }
            for (int j = left; j <= right; j++) {
                dp[i] = Math.max(dp[i], dp[rides[j][0]] + rides[j][1] - rides[j][0] + rides[j][2]);
            }
            if(left <= right){
                left = right + 1;
            }
        }
        return dp[n];
    }
}
