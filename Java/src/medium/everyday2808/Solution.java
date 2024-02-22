package medium.everyday2808;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

public class Solution {
    /**
     * 给你一个下标从 0 开始长度为 n 的数组 nums 。
     *
     * 每一秒，你可以对数组执行以下操作：
     *
     * 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一。
     * 注意，所有元素会被同时替换。
     *
     * 请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。
     */
    public int minimumSeconds(List<Integer> nums) {
        final int[] ans = {9999999};
        int n = nums.size();
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int now = nums.get(i);
            if (!map.containsKey(now)) {
                map.put(now, new int[]{i, i, 0});
            }else {
                int left = map.get(now)[0], right = map.get(now)[1], cnt = map.get(now)[2];
                cnt = Math.max(cnt, (i - right) / 2);
                map.put(now, new int[]{left, i, cnt});
            }
        }
        map.forEach(new BiConsumer<Integer, int[]>() {
            @Override
            public void accept(Integer integer, int[] ints) {
                int left = ints[0], right = ints[1], cnt = ints[2];
                if (left == right){
                    cnt = n / 2;
                } else {
                    cnt = Math.max(cnt, (n - right + left) / 2);
                }
                ans[0] = Math.min(ans[0], cnt);
            }
        });
        return ans[0];
    }
}
