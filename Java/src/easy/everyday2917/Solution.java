package easy.everyday2917;

import java.util.Map;

public class Solution {
    public int findKOr(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[0];
        if (k == 1){
            for (int i = 1; i < n; i++) {
                ans = ans | nums[i];
            }
        } else if (k == n){
            for (int i = 1; i < n; i++) {
                ans = ans & nums[i];
            }
        } else {
            ans = 0;
            int[] flag = new int[32];
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                int now = 0;
                while (x > 0){
                    flag[now] += x & 1;
                    x = x >> 1;
                    now++;
                }
            }
            for (int i = 0; i < 32; i++) {
                if (flag[i] >= k){
                    ans += (int) Math.pow(2, i);
                }
            }
        }
        return ans;
    }
}
