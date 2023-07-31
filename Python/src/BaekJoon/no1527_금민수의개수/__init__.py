import sys
from collections import deque

input = sys.stdin.readline

a, b = map(int, input().rstrip().split())
ans = 0

q = deque([4, 7])
while q:
    cur = q.popleft()
    if cur > b:
        break
    elif a <= cur <= b:
        ans += 1

    next = cur * 10
    q.append(next + 4)
    q.append(next + 7)

print(ans)
