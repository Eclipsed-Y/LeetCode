"""给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。

请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。

题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/max-value-of-equation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from collections import deque
from typing import List


class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        q = deque()
        q.append((points[0][0], points[0][1]))
        ans = -9999999999
        for j in range(1, len(points)):
            x = points[j][0]
            y = points[j][1]
            while len(q) > 0 and x - q[0][0] > k:
                q.popleft()
            if len(q) > 0:
                tmp = y + x - q[0][0] + q[0][1]
                ans = max(tmp, ans)
            while len(q) > 0 and y - x > q[-1][1] - q[-1][0]:
                q.pop()
            q.append((x, y))
        return ans

solu = Solution()
print(solu.findMaxValueOfEquation([[-17,5],[-10,-8],[-5,-13],[-2,7],[8,-14]],4))