package hard.everyday828;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /*
        我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。

例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。

本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。

注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
     */
    public int uniqueLetterString(String s) {
        int n = s.length();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if(arr.get(s.charAt(i) - 'A').isEmpty()){
                arr.get(s.charAt(i) - 'A').add(-1);
            }
            arr.get(s.charAt(i) - 'A').add(i);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if(!arr.get(i).isEmpty()){
                arr.get(i).add(n);
                for (int j = 1; j < arr.get(i).size() - 1; j++) {
                    ans += (arr.get(i).get(j + 1) - arr.get(i).get(j)) * (arr.get(i).get(j) - arr.get(i).get(j - 1));
                }
            }
        }
        return ans;
    }

}
