package medium.everyday670;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     */
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (s.charAt(i) - '0');
        }
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int index = n-1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == arr[index]){
                index--;
            } else {
                for (int j = n - 1; j > i; j--) {
                    if(nums[j] == arr[index]){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        int ans = 0;
                        for (int k = 0; k < n; k++) {
                            ans = ans * 10 + nums[k];

                        }
                        return ans;
                    }
                }
            }
        }
        return num;
    }
}
