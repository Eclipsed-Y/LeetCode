package medium.everyday1954;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    /**
     * 给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。
     * <p>
     * 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。
     * <p>
     * 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。
     *
     * @param neededApples
     * @return
     */
    ArrayList<Long> arr = new ArrayList<>();
    public Solution(){
        arr.add(0L);
    }
    public long minimumPerimeter(long neededApples) {
        if(arr.get(arr.size() - 1) >= neededApples){;
            int idx = Collections.binarySearch(arr, neededApples);
            if(idx >= 0){
                return 8L * idx;
            } else {
                return 8L * (-idx - 1);
            }
        } else {
            long now = arr.get(arr.size() - 1);
            long x = arr.size() - 1;
            while (now < neededApples) {
                x++;
                long tmp = 12 * x * x;
                now += tmp;
                arr.add(now);
            }
        }
        return 8L * (arr.size()- 1);
    }
}
