package medium.everyday2707;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
     *
     * 请你采取最优策略分割 s ，使剩下的字符 最少 。
     */
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < dictionary.length; k++) {
                    if(s.substring(j, i).equals(dictionary[k])){
                        dp[i] = Math.min(dp[i], dp[j]);
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

}
