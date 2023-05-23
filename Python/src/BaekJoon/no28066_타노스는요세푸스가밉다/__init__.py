import sys
from collections import deque


def adv_input():
    return sys.stdin.readline().rstrip()


n, k = map(int, adv_input().split())
dq = deque(i for i in range(1, n + 1))

while n > k:
    dq.rotate(-1)
    for i in range(k - 1):
        dq.popleft()
        n -= 1

print(dq.popleft())
