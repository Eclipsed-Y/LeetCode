package easy.everyday2697;

public class Solution {
    /*
    给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换  s 中的一个字符。

请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。

对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早，则认为 a 的字典序比 b 的字典序要小。

返回最终的回文字符串。
     */
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int[] flag = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - 1 - i)){
                if (s.charAt(i) > s.charAt(n - 1 - i)){
                    flag[i] = n - 1 -i;
                } else {
                    flag[i] = i;
                }
            } else {
                flag[i] = i;
            }
        }
        for (int i = 0; i < flag.length; i++) {
            ans.append(s.charAt(flag[i]));
        }
        if(n % 2 == 1){
            ans.append(s.charAt(n / 2));
        }
        for (int i = flag.length - 1; i >= 0; i--) {
            ans.append(s.charAt(flag[i]));
        }
        return ans.toString();
    }
}
