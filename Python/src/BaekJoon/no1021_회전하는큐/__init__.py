import sys
from collections import deque


def adv_input():
    return sys.stdin.readline().rstrip()


N, M = map(int, adv_input().split())
want = list(map(int, adv_input().split()))

dq = deque(x + 1 for x in range(N))

ans = 0
for i in want:
    if i != dq[0]:
        x = dq.index(i)
        if x <= len(dq) // 2:
            ans += x
            dq.rotate(-x)
        else:
            ans += len(dq) - x
            dq.rotate(len(dq) - x)
    del dq[0]

print(ans)
