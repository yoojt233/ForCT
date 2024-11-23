import sys
from collections import deque

input = sys.stdin.readline

for _ in range(int(input().rstrip())):
    w, n = map(int, input().rstrip().split())
    dq = deque([])
    ans, cur = 0, 0

    for _ in range(n):
        dist, trash = map(int, input().rstrip().split())
        dq.append((dist, trash))

    while dq:
        d, t = dq.popleft()

        if cur + t >= w:
            if cur + t > w: dq.appendleft((d, t))
            cur = 0
            ans += 2 * d
        else:
            cur += t
            if not dq: ans += 2 * d

    print(ans)
