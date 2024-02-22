package medium.everyday2182;

public class Solution {
    /**
     * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
     *
     * 返回 字典序最大的 repeatLimitedString 。
     *
     * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)- 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int re = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 25; j >= 0; j--) {
                if(arr[j] > 0){
                    if(i == 0 || re < repeatLimit && sb.charAt(i-1) == (char)(j + 'a')){
                        re++;
                        sb.append((char)(j + 'a'));
                        arr[j]--;
                        break;
                    } else if(sb.charAt(i-1) != (char)(j + 'a')){
                        re = 1;
                        sb.append((char)(j + 'a'));
                        arr[j]--;
                        break;
                    }
                }
                if(j == 0){
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}
