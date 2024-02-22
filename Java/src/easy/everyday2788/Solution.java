package easy.everyday2788;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
     *
     * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
     */
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        words.forEach((word) -> {
            String[] split = word.split("\\" + separator);
            for (String s : split) {
                if (s != null && !s.isEmpty()){
                    ans.add(s);
                }
            }
        });
        return ans;
    }
}
