package hard.everyday2719;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数：
     * <p>
     * num1 <= x <= num2
     * min_sum <= digit_sum(x) <= max_sum.
     * 请你返回好整数的数目。答案可能很大，请返回答案对 109 + 7 取余后的结果。
     * <p>
     * 注意，digit_sum(x) 表示 x 各位数字之和。
     */
    final int mod = 1000000007;
    long[][] dp;
    boolean flag;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        flag = false;
        dp = new long[num2.length() + 1][num2.length() * 9 + 1];
        int tmp = 0;
        for (int i = 0; i < num1.length(); i++) {
            tmp += (num1.charAt(i) - '0');
        }
        if (tmp < min_sum || tmp > max_sum) {
            tmp = 0;
        } else {
            tmp = 1;
        }
        return (int) (recur(num2, min_sum, max_sum) + mod - recur(num1, min_sum, max_sum) + tmp) % mod;
    }

    // 找出n位内，数字位数和在min_sum和max_sum之间的数字个数
    public long find(int n, int min_sum, int max_sum) {
        if (n <= 0 || max_sum < 0) {
            return 0;
        }
        if (!flag){
            for (int i = 0; i <= 9; i++) {
                dp[1][i] = 1;
            }
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= n * 9; j++) {
                    if (j > max_sum) {
                        break;
                    }
                    for (int k = 0; k <= 9; k++) {
                        if (j - k < 0) {
                            continue;
                        }
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
            flag = true;
        }

        long ans = 0;
        for (int i = Math.max(0, min_sum); i <= max_sum; i++) {
            if (i >= dp[0].length) {
                break;
            }
            ans = (ans + dp[n][i]) % mod;
        }
        return ans;
    }

    public long recur(String num, int min_sum, int max_sum) {
        if (max_sum < 0) {
            return 0;
        }
        int n = num.charAt(0) - '0';
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + find(num.length() - 1, min_sum - i, max_sum - i)) % mod;
        }
        if (num.length() == 1) {
            long tmp = 0;
            for (int i = 0; i <= n; i++) {
                if (i >= min_sum && i <= max_sum) {
                    tmp += 1;
                }
            }
            return tmp;
        }
        res = (res + recur(num.substring(1), min_sum - n, max_sum - n)) % mod;
        return res;
    }
}
