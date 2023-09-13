import sys

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
impossible = set()
for _ in range(m):
    impossible.add(int(input().rstrip()))

highest = int((2 * n) ** 0.5) + 1
dp = [[sys.maxsize for _ in range(highest + 1)] for _ in range(n + 1)]
dp[1][0] = 0

for next in range(2, n + 1):
    if next in impossible: continue
    for speed in range(1, highest):
        before = dp[next - speed]
        dp[next][speed] = min(before[speed - 1], before[speed], before[speed + 1]) + 1

ans = min(dp[n])
print(-1 if ans == sys.maxsize else ans)
