class Solution:
    def ways(self, pizza: list[str], k: int) -> int:
        m = len(pizza)
        n = len(pizza[0])
        mod = 10 ** 9 + 7
        have = []
        for i in range(m + 1):
            have.append(([0] * (n + 1)))
        dp = [[[0 for _ in range(n)] for _ in range(m)] for _ in range(k + 1)]
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                have[i][j] = (pizza[i][j] == 'A') + have[i + 1][j] + have[i][j + 1] - have[i + 1][j + 1]
                dp[1][i][j] = 1 if have[i][j] else 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                for x in range(2, k + 1):
                    for h in range(i + 1, m):
                        if have[i][j] > have[h][j]:
                            dp[x][i][j] = (dp[x][i][j] + dp[x - 1][h][j]) % mod
                    for v in range(j + 1, n):
                        if have[i][j] > have[i][v]:
                            dp[x][i][j] = (dp[x][i][j] + dp[x - 1][i][v]) % mod
        return dp[k][0][0]

solu = Solution()
print(solu.ways(["A..","AAA","..."], 3))