import copy
import sys

input = sys.stdin.readline

n = int(input().rstrip())
origin = list(input().rstrip())

ans = 0
for _ in range(n - 1):
    temp = list(input().rstrip())
    standard = copy.deepcopy(origin)

    for c in origin:
        if c in temp:
            temp.remove(c)
            standard.remove(c)

    if len(temp) <= 1 and len(standard) <= 1: ans += 1

print(ans)
