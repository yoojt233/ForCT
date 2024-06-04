import sys
from collections import deque

input = sys.stdin.readline


def take_out(stack):
    global target

    while stack and stack[0] == target:
        stack.popleft()
        target += 1


n = int(input().rstrip())
q, stack = deque(list(map(int, input().rstrip().split()))), deque([])
target = 1

while q:
    take_out(stack)

    cur = q.popleft()
    if cur == target:
        target += 1
    else:
        stack.appendleft(cur)

take_out(stack)

print("Nice" if target == n + 1 else "Sad")
