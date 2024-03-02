import sys
from collections import deque

input = sys.stdin.readline


def bfs(op):
    global most

    visited = [False for _ in range(n + 1)]
    visited[op] = True

    q = deque([op])
    temp = 0

    while q:
        cur = q.popleft()
        for next in graph[cur]:
            if visited[next]: continue

            visited[next] = True
            q.append(next)
            temp += 1

    most = max(most, temp)
    return temp


n, m = map(int, input().rstrip().split())
graph = {i: [] for i in range(n + 1)}

for _ in range(m):
    a, b = map(int, input().rstrip().split())
    graph[b].append(a)

most = 0
cnt = [bfs(i) for i in range(1, n + 1)]

ans = []
for i in range(n):
    if cnt[i] == most: ans.append(str(i + 1))

print(' '.join(ans))
