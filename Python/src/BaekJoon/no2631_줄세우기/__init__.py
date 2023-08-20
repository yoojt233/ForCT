import sys
import bisect

input = sys.stdin.readline

n = int(input().rstrip())
nums = [int(input().rstrip()) for _ in range(n)]

dp = [nums[0]]
for i in range(n):
    num = nums[i]
    if num > dp[-1]:
        dp.append(num)
    else:
        where = bisect.bisect_left(dp, num)
        dp[where] = num

print(n - len(dp))
