import sys

input = sys.stdin.readline

n = int(input().rstrip())
arr = [[sys.maxsize for _ in range(n)] for _ in range(n)]

while True:
    f, t = map(int, input().rstrip().split())
    if f == -1 and t == -1: break
    arr[f - 1][t - 1] = arr[t - 1][f - 1] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            if i == k or j == k:
                continue
            elif i == j:
                arr[i][j] = arr[j][i] = 0
                continue
            dist = arr[i][k] + arr[k][j]
            if dist < arr[i][j]: arr[i][j] = arr[j][i] = dist

points = [max(arr[i]) for i in range(n)]
p, cnt = min(points), 0
ans = []
for i in range(n):
    if points[i] != p: continue
    cnt += 1
    ans.append(i + 1)

print(p, cnt)
print(*ans)
