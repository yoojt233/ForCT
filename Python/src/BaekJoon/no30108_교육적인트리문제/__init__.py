import sys
import heapq

input = sys.stdin.readline

n = int(input().rstrip())
input()
nums = list(map(int, input().rstrip().split()))

hq = []
heapq.heapify(hq)

for n in nums:
    heapq.heappush(hq, -n)

ans = 0
while hq:
    ans -= (heapq.heappop(hq))
    print(ans)
