package medium.everyday2735;

import java.util.Arrays;

public class Solution {
    /**
     * 给你一个长度为 n 、下标从 0 开始的整数数组 nums ，表示收集不同巧克力的成本。每个巧克力都对应一个不同的类型，最初，位于下标 i 的巧克力就对应第 i 个类型。
     *
     * 在一步操作中，你可以用成本 x 执行下述行为：
     *
     * 同时修改所有巧克力的类型，将巧克力的类型 ith 修改为类型 ((i + 1) mod n)th。
     * 假设你可以执行任意次操作，请返回收集所有类型巧克力所需的最小成本。
     */
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] now = nums.clone();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += now[i];
        }
        for (int i = 1; i < n; i++) {
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                now[j] = Math.min(nums[(j + i) % n], now[j]);
                tmp += now[j];
            }
            ans = Math.min(ans, tmp + (long) x * i);
        }
        return ans;
    }
}
