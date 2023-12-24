"""在二维网格 grid 上，有 4 种类型的方格：

1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。

每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。"""
import array


class Solution:
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    target = 0
    ans = 0

    def dfs(self, grid, x, y, step, m, n, hash):
        for i in range(4):
            nextx = x + self.dx[i]
            nexty = y + self.dy[i]
            if nextx >= 0 and nextx < m and nexty >= 0 and nexty < n:
                if grid[nextx][nexty] == 0 and hash[nextx][nexty] == 0:
                    if step > self.target:
                        continue
                    hash[nextx][nexty] = 1
                    self.dfs(grid, nextx, nexty, step + 1, m, n, hash)
                elif grid[nextx][nexty] == 2 and step == self.target:
                    self.ans += 1
        hash[x][y] = 0

    def uniquePathsIII(self, grid: list[list[int]]) -> int:
        hash = []
        self.ans = 0
        m = len(grid)
        n = len(grid[0])
        for _ in range(m):
            hash.append([0] * n)
        startx, starty = (0, 0)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    self.target += 1
                if grid[i][j] == 1:
                    startx = i
                    starty = j
        self.dfs(grid, startx, starty, 0, m, n, hash)
        return self.ans


solu = Solution()
print(solu.uniquePathsIII([[1,0,0,0],[0,0,0,0],[0,0,0,2]]))
