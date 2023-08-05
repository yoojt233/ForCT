import sys
import heapq

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
numbers = list(map(int, input().rstrip().split()))
heapq.heapify(numbers)

for _ in range(m):
    x, y = heapq.heappop(numbers), heapq.heappop(numbers)
    for _ in range(2):
        heapq.heappush(numbers, x + y)

print(sum(numbers))
