package medium.everyday2645;

import java.util.Arrays;

public class Solution {
    /**
     * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
     *
     * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
     * @param word
     * @return
     */
    public int addMinimum(String word) {
        int n = word.length();
        int now = 0;
        int ans = 0;
        while (now < n){
            if (word.charAt(now) == 'c'){
                ans += 2;
            } else if(word.charAt(now) == 'b'){
                if (now == n - 1 || now + 1 < n && word.charAt(now + 1) != 'c'){
                    ans += 2;
                } else if (now + 1 < n && word.charAt(now + 1) == 'c'){
                    ans += 1;
                    now ++;
                }
            } else {
                if (now == n - 1 || now + 1 < n && word.charAt(now + 1) == 'a'){
                    ans += 2;
                } else {
                    if (now + 1 < n && word.charAt(now + 1) == 'c'){
                        ans += 1;
                        now ++;
                    } else {
                        if (now + 2 < n && word.charAt(now + 2) == 'c'){
                            now += 2;
                        } else {
                            ans += 1;
                            now ++;
                        }
                    }
                }
            }
            now ++;
        }
        return ans;
    }
}
