"""给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）

请你返回将 nums 数组和 至少 减少一半的 最少 操作数。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-operations-to-halve-array-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
import heapq


class Solution:
    def halveArray(self, nums: list[int]) -> int:
        heap = []
        ans = 0.0
        for x in nums:
            heapq.heappush(heap, -float(x))
            ans += float(x)
        target = ans / 2
        cnt = 0
        while ans > target:
            cnt += 1
            x = -heapq.heappop(heap)
            x /= 2
            ans -= x
            heapq.heappush(heap, -x)
        return cnt


solu = Solution()
print(solu.halveArray([5, 19, 8, 1]))
