import sys

input = sys.stdin.readline

n = int(input().rstrip())
prices = list(map(int, input().rstrip().split()))
m = int(input().rstrip())
dp = [0 for _ in range(m + 1)]

for i in range(n - 1, -1, -1):
    cur = prices[i]
    for j in range(cur, m + 1):
        dp[j] = max(dp[j], i, dp[j - cur] * 10 + i)

print(dp[m])
