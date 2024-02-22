package easy.everyday2085;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Solution {
    /**
     * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
     */
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (String s : words1) {
            if (map1.containsKey(s)){
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }
        }
        for (String s : words2) {
            if (map2.containsKey(s)){
                map2.put(s, map2.get(s) + 1);
            } else {
                map2.put(s, 1);
            }
        }
        final int[] ans = {0};
        map1.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                if (integer == 1 && map2.containsKey(s) && map2.get(s) == 1){
                    ans[0]++;
                }
            }
        });
        return ans[0];
    }
}
