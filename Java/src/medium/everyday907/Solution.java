package medium.everyday907;

import java.util.Arrays;

public class Solution {
    /*
    给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。

由于答案可能很大，因此 返回答案模 10^9 + 7 。
     */
    public int sumSubarrayMins(int[] arr) {
        long ans = 0L;
        for (int i = 0; i < arr.length; i++) {
            long tmp = arr[i];
            int left = i - 1, right = i + 1;
            while (left >= 0 && arr[left] > tmp){
                left --;
            }
            while (right < arr.length && arr[right] >= tmp){
                right ++;
            }
            ans = (tmp * (i - left) * (right - i) + ans) % 1000000007;
        }
        return (int)ans;
    }
}

