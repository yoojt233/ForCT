import sys

input = sys.stdin.readline

n, x = map(int, input().rstrip().split())
visitors = list(map(int, input().rstrip().split()))

visitor, chance = sum(visitors[0:x]), 1
ans = visitor
for i in range(1, n - x + 1):
    visitor -= visitors[i - 1]
    visitor += visitors[x + i - 1]
    if visitor > ans:
        ans = visitor
        chance = 1
    elif visitor == ans:
        chance += 1

if visitor != 0:
    print(ans)
    print(chance)
else:
    print("SAD")
