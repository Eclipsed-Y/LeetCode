package easy.everyday2859;

import java.util.List;
import java.util.function.Consumer;

public class Solution {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     *
     * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
     *
     * 整数的二进制表示中的 1 就是这个整数的 置位 。
     *
     * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans =0;
        for (int i = 0; i < nums.size(); i++) {
            int tmp = i;
            int res = 0;
            while (tmp > 0){
                res += tmp%2;
                tmp /= 2;
            }
            if (res == k){
                ans +=
                        nums.get(i);
            }
        }
        return ans;
    }
}
