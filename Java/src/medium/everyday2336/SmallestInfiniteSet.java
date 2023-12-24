package medium.everyday2336;

import java.util.HashSet;
import java.util.Iterator;

public class SmallestInfiniteSet {
    /*
        现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。

        实现 SmallestInfiniteSet 类：

        SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
        int popSmallest() 移除 并返回该无限集中的最小整数。
        void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
     */
    private HashSet<Integer> hs;
    public SmallestInfiniteSet() {
        hs = new HashSet<>();
    }

    public int popSmallest() {
        if(hs.isEmpty()){
            hs.add(1);
            return 1;
        }
        Iterator<Integer> it = hs.iterator();

        Integer pre = it.next();
        Integer tmp = pre;
        if (tmp > 1){
            hs.add(1);
            return 1;
        }
        while(it.hasNext()){
            tmp = it.next();
            if (tmp != pre + 1){
                hs.add(pre + 1);
                return pre + 1;
            }
            pre = tmp;
        }
        hs.add(tmp + 1);
        return tmp + 1;
    }

    public void addBack(int num) {
        if(hs.contains(num)){
            hs.remove(num);
        }
    }
}
