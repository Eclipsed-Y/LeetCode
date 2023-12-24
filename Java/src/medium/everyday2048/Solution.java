package medium.everyday2048;

public class Solution {
    /*
    如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。

给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
     */


    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            int[] hash = new int[10];
            int tmp = i;
            while(tmp > 0){
                hash[tmp % 10] += 1;
                tmp /= 10;
            }
            int flag = 0;
            for (int j = 0; j < 10; j++) {
                if(hash[j] > 0 && hash[j] != j){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
    }
}
