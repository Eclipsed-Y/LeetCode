package medium.everyday1423;

public class Solution {
    /*
    几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。

每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。

你的点数就是你拿到手中的所有卡牌的点数之和。

给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
     */
    public int maxScore(int[] cardPoints, int k) {
        int left = -1, right = cardPoints.length - k;
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += cardPoints[right + i];
        }
        int ans = tmp;
        for (int i = 0; i < k; i++) {
            left += 1;
            right += 1;
            tmp = tmp + cardPoints[left] - cardPoints[right - 1];
            ans = Math.max(tmp, ans);
        }
        return ans;
    }
}
