package medium.everyday2397;

public class Solution {
    /**
     * 给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
     * <p>
     * 如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被 覆盖 了。
     * <p>
     * 形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
     * <p>
     * 对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
     * row 中 不存在 值为 1 的单元格。
     * 你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
     * <p>
     * 返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数 。
     */
    int ans = 0;
    int m = 0;
    int n = 0;
    int[][] arr = null;

    public int maximumRows(int[][] matrix, int numSelect) {
        ans = 0;
        arr = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int[] have = new int[n];
        dfs(have, 0, numSelect);
        return ans;
    }

    public void dfs(int[] have, int idx, int last) {
        if (n - idx < last) {
            return;
        }
        if (last == 0){
            ans = Math.max(ans, check(have));
        } else {
            for (int i = idx; i <= n - last; i++) {
                have[i] = 1;
                dfs(have, i + 1, last - 1);
                have[i] = 0;
            }
        }
    }

    private int check(int[] have) {
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && have[j] == 0){
                    break;
                }
                if(j == n - 1){
                    tmp++;
                }
            }
        }
        return tmp;
    }
}
