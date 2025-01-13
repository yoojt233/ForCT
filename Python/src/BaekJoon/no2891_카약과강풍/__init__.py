import sys

input = sys.stdin.readline

n, s, r = map(int, input().rstrip().split())
kayaks = [1 for _ in range(n)]

for i in list(map(int, input().rstrip().split())): kayaks[i - 1] = 0
for i in list(map(int, input().rstrip().split())): kayaks[i - 1] += 1

ans = 0

for i in range(n):
    if kayaks[i] > 0 or (i - 1 >= 0 and kayaks[i - 1] > 1): continue
    if i + 1 < n and kayaks[i + 1] > 1:
        kayaks[i + 1] -= 1
        continue

    ans += 1

print(ans)
