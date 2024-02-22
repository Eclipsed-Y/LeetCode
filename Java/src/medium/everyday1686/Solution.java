package medium.everyday1686;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * Alice 和 Bob 轮流玩一个游戏，Alice 先手。
     *
     * 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。
     *
     * 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。
     *
     * 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。
     *
     * 请你推断游戏的结果，用如下的方式表示：
     *
     * 如果 Alice 赢，返回 1 。
     * 如果 Bob 赢，返回 -1 。
     * 如果游戏平局，返回 0 。
     */
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int [][] sum = new int[n][2];
        for (int i = 0; i < n; i++) {
            sum[i][0] = aliceValues[i] + bobValues[i];
            sum[i][1] = i;
        }
        Arrays.sort(sum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int a = 0, b = 0, idx = 0;
        while (idx < n){
            a += aliceValues[sum[idx][1]];
            idx ++;
            if (idx < n){
                b += bobValues[sum[idx][1]];
                idx ++;
            }
        }
        return Integer.compare(a, b);
    }
}
