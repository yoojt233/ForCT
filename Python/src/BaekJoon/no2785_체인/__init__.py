import sys
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())
chains = deque(sorted(list(map(int, input().rstrip().split()))))

ans = 0
while True:
    chains[0] -= 1
    ans += 1

    chains.append(chains.pop() + chains.pop())
    if chains[0] == 0: chains.popleft()
    if len(chains) == 1: break

print(ans)
