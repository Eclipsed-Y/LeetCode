package hard.everyday2454;

import java.util.*;

public class Solution {
    /*
    给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。

如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：

j > i
nums[j] > nums[i]
恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
如果不存在 nums[j] ，那么第二大整数为 -1 。

比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。
请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。
     */
    public int[] secondGreaterElement(int[] nums) {
        Stack<int[]>s1 = new Stack<>(), s2 = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<int[]>tmp = new Stack<>();
        for (int i = 0; i < nums.length; i++) {

            while (!s1.empty() && s1.peek()[0] < nums[i]) {
                tmp.push(s1.pop());
            }
            while (!s2.empty() && s2.peek()[0] < nums[i]){
                ans[s2.pop()[1]] = nums[i];
            }
            while (!tmp.empty()){
                s2.push(tmp.pop());
            }
            s1.push(new int[]{nums[i], i});
        }
        return ans;

    }
}
