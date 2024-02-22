package easy.everyday2670;

import java.util.HashSet;

public class Solution {
    /**
     * 给你一个下标从 0 开始的数组 nums ，数组长度为 n 。
     *
     * nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
     *
     * 返回 nums 的 不同元素数目差 数组。
     *
     * 注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            HashSet<Integer> pre = new HashSet<>(), sub = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                pre.add(nums[j]);
            }
            for (int j = i + 1; j < n; j++) {
                sub.add(nums[j]);
            }
            ans[i] = pre.size() - sub.size();
        }
        return ans;
    }
}
