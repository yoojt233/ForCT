import sys

input = sys.stdin.readline

n = int(input().rstrip())
work = [(0, 0)]
for _ in range(n):
    t, p = map(int, input().rstrip().split())
    work.append((t, p))

dp = [0 for _ in range(n + 1)]
for i in range(1, n + 1):
    dp[i] = max(dp[i], dp[i - 1])
    end = i + work[i][0] - 1

    if end > n: continue
    dp[end] = max(dp[end], dp[i - 1] + work[i][1])

print(dp[n])
