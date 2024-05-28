import sys

input = sys.stdin.readline

n = int(input().rstrip())
matrixes = [list(map(int, input().rstrip().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]

for i in range(1, n):
    for op in range(n):
        ed = op + i
        if ed >= n: break

        dp[op][ed] = int(1e9)
        for x in range(op, ed):
            dp[op][ed] = min(dp[op][ed],
                             dp[op][x] + dp[x + 1][ed] + matrixes[op][0] * matrixes[x][1] * matrixes[ed][1])

print(dp[0][n - 1])
