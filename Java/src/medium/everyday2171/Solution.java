package medium.everyday2171;

import java.util.Arrays;

public class Solution {
    /**
     * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
     * <p>
     * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
     * <p>
     * 请返回你需要拿出魔法豆的 最少数目。
     */
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long suf = 0;
        for (int i = 1; i < n; i++) {
            suf += beans[i];
        }
        long pre = 0;
        long ans = suf - (long) beans[0] * (n - 1);
        for (int i = 1; i < n; i++) {
            pre += beans[i - 1];
            suf -= beans[i];
            ans = Math.min(ans, pre + suf - (long) beans[i] * (n - i - 1));
        }
        return ans;
    }
}
