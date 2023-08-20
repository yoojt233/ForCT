import sys

input = sys.stdin.readline

n = int(input().rstrip())
nums = [int(input().rstrip()) for _ in range(n)]

dp = [1 for _ in range(n)]
for i in range(1, n):
    num = nums[i]
    for j in range(i):
        if num > nums[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))
