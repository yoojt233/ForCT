import sys

input = sys.stdin.readline

mod = 1_000_000_009
dp = [0, 1, 2, 4]
for x in range(int(input().rstrip())):
    n = int(input().rstrip())
    while n >= len(dp):
        dp.append((dp[-1] + dp[-2] + dp[-3]) % mod)
    print(dp[n])
