"""机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：

-2 ：向左转 90 度
-1 ：向右转 90 度
1 <= x <= 9 ：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。

机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。

返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）

 
注意：

北表示 +Y 方向。
东表示 +X 方向。
南表示 -Y 方向。
西表示 -X 方向。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/walking-robot-simulation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from typing import List


class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        hash = set()
        for ob in obstacles:
            hash.add(tuple(ob))
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        k = 0
        ans = 0
        x = 0
        y = 0
        for cmd in commands:
            if cmd == -1:
                k = (k + 1) % 4
            elif cmd == -2:
                k = (k + 3) % 4
            else:
                last = cmd
                while last > 0:
                    last -= 1
                    tarx = x + dx[k]
                    tary = y + dy[k]
                    if (tarx, tary) in hash:
                        break
                    else:
                        x = tarx
                        y = tary
                        ans = max(ans, x * x + y * y)
        return ans


solu = Solution()
print(solu.robotSim([4, -1, 4, -2, 4], [[2, 4]]))
