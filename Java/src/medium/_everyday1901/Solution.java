package medium._everyday1901;

public class Solution {
    /**
     * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
     *
     * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
     *
     * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
     *
     * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
     */
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int left = 0, right = m - 1;
        while (left <= right){
            int now = (left + right) / 2;
            int maxNow = mat[now][0];
            int idxMax = 0;
            for (int i = 0; i < n; i++) {
                if(mat[now][i]>maxNow){
                    maxNow = mat[now][i];
                    idxMax = i;;
                }
            }
            if(left == right){
                return new int[]{now,idxMax};
            }
            if(now == 0){
                if(mat[now][idxMax]>mat[now+1][idxMax]){
                    return new int[]{now, idxMax};
                } else {
                    left = now + 1;
                }
            } else if(now == m - 1){
                if (mat[now][idxMax]> mat[now - 1][idxMax]){
                    return new int[]{now, idxMax};
                } else {
                    right = now - 1;
                }
            } else {
                if(mat[now][idxMax]>mat[now-1][idxMax] && mat[now][idxMax]>mat[now+1][idxMax]){
                    return new int[]{now, idxMax};
                } else if(mat[now][idxMax]>mat[now-1][idxMax]){
                    left = now + 1;
                } else {
                    right = now - 1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
