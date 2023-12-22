import itertools
import sys

input = sys.stdin.readline

for _ in range(int(input().rstrip())):
    n = int(input().rstrip())
    files = list(map(int, input().rstrip().split()))
    merge = [0] + list(itertools.accumulate(files))
    dp = [[0 for _ in range(n + 1)] for _ in range(n + 1)]

    for j in range(2, n + 1):
        for i in range(j - 1, 0, -1):
            dp[i][j] = sys.maxsize

            for k in range(i, j):
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j])
            dp[i][j] += (merge[j] - merge[i - 1])

    print(dp[1][n])
