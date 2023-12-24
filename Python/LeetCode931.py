"""给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-falling-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        pre = matrix[0].copy()
        now = pre.copy()
        for i in range(1, m):
            for j in range(n):
                if j == 0:
                    if n == 1:
                        now[j] = pre[j] + matrix[i][j]
                    else:
                        now[j] = min(pre[j], pre[j + 1]) + matrix[i][j]
                elif j == n - 1:
                    if n == 1:
                        now[j] = pre[j] + matrix[i][j]
                    else:
                        now[j] = min(pre[j], pre[j - 1]) + matrix[i][j]
                else:
                    now[j] = min(pre[j], pre[j - 1], pre[j + 1]) + matrix[i][j]
            pre = now.copy()
        return min(now)