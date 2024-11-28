import sys

input = sys.stdin.readline

n = int(input().rstrip())
dp = [0, 1]

while len(dp) <= n: dp.append(dp[-1] + dp[-2])

print(dp[n])
