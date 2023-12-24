"""给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        ans = []
        nums.sort()
        for i in range(n - 2):
            if nums[i] > 0:
                return ans
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            k = n - 1
            for j in range(i + 1, n - 1):
                if k <= j:
                    break
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                tmp = nums[i] + nums[j]
                if tmp > 0:
                    break
                while nums[k] > -tmp and k > j + 1:
                    k -= 1
                if nums[k] == -tmp:
                    ans.append([nums[i], nums[j], nums[k]])

        return ans


nums = [3,-2,1,0]
solu = Solution()
print(solu.threeSum(nums))
