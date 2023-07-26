import sys
import heapq

input = sys.stdin.readline


class ShortCut:
    def __init__(self, op, ed, dist):
        self.op = op
        self.ed = ed
        self.dist = dist

    def __lt__(self, other):
        return self.ed < other.ed


n, d = map(int, input().rstrip().split())
pq = []

for _ in range(n):
    op, ed, dist = map(int, input().rstrip().split())
    heapq.heappush(pq, ShortCut(op, ed, dist))

dp = [0 for _ in range(10001)]
for i in range(1, d + 1):
    dp[i] = dp[i - 1] + 1
    while pq and i == pq[0].ed:
        cur = heapq.heappop(pq)
        dp[i] = min(dp[i], dp[cur.op] + cur.dist)

print(dp[d])
