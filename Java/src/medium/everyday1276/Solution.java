package medium.everyday1276;

import java.util.List;

public class Solution {
    /**
     * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
     * <p>
     * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
     * <p>
     * 巨无霸汉堡：4 片番茄和 1 片奶酪
     * 小皇堡：2 片番茄和 1 片奶酪
     * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
     * <p>
     * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
     *
     * @param tomatoSlices
     * @param cheeseSlices
     * @return
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        return (tomatoSlices - 2 * cheeseSlices) % 2 == 0 && cheeseSlices - (tomatoSlices - 2 * cheeseSlices) / 2 >= 0 && (tomatoSlices - 2 * cheeseSlices) / 2 >= 0 ? List.of((tomatoSlices - 2 * cheeseSlices) / 2, cheeseSlices - (tomatoSlices - 2 * cheeseSlices) / 2) : List.of();
    }
}
