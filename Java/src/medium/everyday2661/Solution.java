package medium.everyday2661;

import java.util.HashMap;

public class Solution {
    /*
    给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。

从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。

请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
     */
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]>mapping = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = j;
                mapping.put(mat[i][j], tmp);
            }
        }
        HashMap<Integer, Integer>hm = new HashMap<>();
        HashMap<Integer, Integer>hn = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int now_i = mapping.get(arr[i])[0];
            int now_j = mapping.get(arr[i])[1];
            int tmp;
            if(hm.containsKey(now_i)){
                tmp = hm.get(now_i) + 1;
                hm.put(now_i, tmp);
            } else{
                tmp = 1;
                hm.put(now_i, tmp);
            }
            if (tmp == n){
                return i;
            }
            if(hn.containsKey(now_j)){
                tmp = hn.get(now_j) + 1;
                hn.put(now_j, tmp);
            } else{
                tmp = 1;
                hn.put(now_j, tmp);
            }
            if (tmp == m){
                return i;
            }
        }
        return m * n - 1;
    }

    public static void main(String[] args) {
        int[]arr = {10, 12, 1, 7, 2, 6, 9, 11, 8, 5, 3, 4};
        int[][] mat = {{8, 1, 6, 10}, {5, 9, 2, 4},{12, 3, 7, 11}};
        firstCompleteIndex(arr, mat);
    }
}
