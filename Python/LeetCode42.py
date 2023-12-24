"""给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。"""
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        s = []
        ans = 0
        for i in range(len(height)):
            if len(s) == 0 and height[i] == 0:
                continue
            if len(s) == 0 and height[i] != 0 or s[-1][1] >= height[i]:
                s.append((i, height[i]))
            elif s[-1][1] < height[i]:
                count = 0
                tmp = 0
                preh = -1
                pre = 0
                while len(s) > 1 and s[-1][1] < height[i]:
                    if preh >= 0:
                        if s[-1][1] <= height[i]:
                           tmp += (height[i] - preh) * (pre - s[-1][0] - 1)
                    count += 1
                    tmp += (height[i] - s[-1][1])
                    pre, preh = s.pop()
                if preh >= 0:
                    tmp += (height[i] - preh) * (pre - s[-1][0] - 1)
                if len(s) > 1 or len(s) == 1 and s[0][1] >= height[i]:
                    ans += tmp
                    s.append((i, height[i]))
                elif len(s) == 1 and s[0][1] < height[i]:
                    ans += (tmp - (height[i] - s[0][1]) * (i - s[0][0] - 1))
                    s.pop()
                    s.append((i, height[i]))
        return ans


solu = Solution()
print(solu.trap([6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3]))
