import sys

input = sys.stdin.readline

N, limit = map(int, input().rstrip().split())
M = int(input())

edges = []
for _ in range(M):
    u, v, box = map(int, input().rstrip().split())
    edges.append((u, v, box))
edges.sort(key=lambda x: x[1])

ans = 0
visited = [0 for _ in range(N + 1)]
for u, v, box in edges:
    temp = box
    for i in range(u, v):
        if visited[i] + temp >= limit:
            temp = limit - visited[i]
    for i in range(u, v):
        visited[i] += temp
    ans += temp
print(ans)
