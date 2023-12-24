"""一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。

比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。

一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-alternating-subsequence-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from typing import List


class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0] * n, [0] * n]
        dp[0][0] = nums[0]
        dp[1][0] = 0
        for i in range(1, n):
            dp[0][i] = max(dp[1][i - 1] + nums[i], dp[0][i - 1])
            dp[1][i] = max(dp[0][i - 1] - nums[i], dp[1][i - 1])
        return max(dp[0][n - 1], dp[1][n - 1])
