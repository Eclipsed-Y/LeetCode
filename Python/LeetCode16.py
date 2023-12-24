"""给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        n = len(nums)
        nums.sort()
        ans = nums[0] + nums[1] + nums[2]
        for i in range(n - 2):
            k = n - 1
            j = i + 1
            while k > j:
                tmp = nums[i] + nums[j] + nums[k]
                ans = tmp if abs(tmp - target) < abs(ans - target) else ans
                if tmp > target:
                    k -= 1
                elif tmp < target:
                    j += 1
                else:
                    return target
        return ans