"""给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。

环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。

子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-sum-circular-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from collections import deque
from typing import List


class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        n = len(nums)
        q = deque()
        pre, res = nums[0], nums[0]
        q.append((0, pre))
        for i in range(1, 2 * n):
            while len(q) > 0 and q[0][0] < i - n:
                q.popleft()
            pre += nums[i % n]
            res = max(res, pre - q[0][1])
            while len(q) > 0 and q[-1][1] >= pre:
                q.pop()
            q.append((i, pre))
        return res


solu = Solution()
print(solu.maxSubarraySumCircular([2, -1, 3, -2]))
