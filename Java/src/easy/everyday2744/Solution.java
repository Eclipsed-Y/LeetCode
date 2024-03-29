package easy.everyday2744;

import java.util.HashSet;


public class Solution {
    /**
     * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
     *
     * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
     *
     * 字符串 words[i] 等于 words[j] 的反转字符串。
     * 0 <= i < j < words.length
     * 请你返回数组 words 中的 最大 匹配数目。
     *
     * 注意，每个字符串最多匹配一次。
     */
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            set.add(i);
            for (int j = i + 1; j < words.length; j++) {
                if (set.contains(j)){
                    continue;
                }
                if (isReverse(words[i], words[j])){
                    ans++;
                    set.add(j);
                }
            }
        }
        return ans;
    }

    private boolean isReverse(String word1, String word2) {
        if (word1.length() != word2.length()){
            return false;
        }
        int i = 0, j = word2.length() - 1;
        while (i < word1.length()){
            if(word1.charAt(i) != word2.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
