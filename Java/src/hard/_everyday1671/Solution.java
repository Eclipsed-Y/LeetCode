package hard._everyday1671;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Solution {
    /**
     * 我们定义 arr 是 山形数组 当且仅当它满足：
     *
     * arr.length >= 3
     * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {
        int[] pre = getList(nums);
        int[] suf = getList(reverse(nums));
        suf = reverse(suf);
        int ans = 9999;
        for (int i = 1; i < nums.length - 1; i++) {
            if(pre[i] > 1 && suf[i] > 1){
                ans = Math.min(ans, nums.length - pre[i] - suf[i] + 1);
            }
        }
        return ans;
    }

    private int[] getList(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if(arr.isEmpty()){
                arr.add(nums[i]);
                res[i] = 1;
            } else {
                // 二分查找第一个比nums[i]小的位置
                int idx = Collections.binarySearch(arr, nums[i]);  // 找到就返回索引，否则为-idxTarget - 1，其中idxTarget为应该插入的位置
                if (idx >= 0){
                    res[i] = idx + 1;
                } else {
                    idx = -idx - 1;
                    if(idx >= arr.size()){
                        arr.add(nums[i]);
                        res[i] = arr.size();
                    } else {
                        arr.set(idx, nums[i]);
                        res[i] = idx + 1;
                    }
                }
            }
        }
        return res;
    }

    private int[] reverse(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[n - 1 - i];
        }
        return res;
    }
}
