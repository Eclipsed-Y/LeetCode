"""给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        ans = []
        nums.sort()
        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                right = n - 1
                for k in range(j + 1, n - 1):
                    if right <= k:
                        break
                    if k > j + 1 and nums[k] == nums[k - 1]:
                        continue
                    while nums[right] + nums[i] + nums[j] + nums[k] > target and right > k + 1:
                        right -= 1
                    if nums[right] + nums[i] + nums[j] + nums[k] == target:
                        ans.append([nums[i], nums[j], nums[k], nums[right]])

        return ans


solu = Solution()
print(solu.fourSum([-1,0,-5,-2,-2,-4,0,1,-2], -9))
