import sys
from collections import deque

input = sys.stdin.readline


def bfs(graph, dist, path):
    q = deque([0])
    while q:
        cur = q.popleft()
        cost = dist[cur]

        for next in graph[cur]:
            if dist[next] < cost:
                continue
            elif dist[next] > cost:
                dist[next] = cost + 1
                q.append(next)
            path[next].append(cur)


def solve(n, dist, path):
    res = set([n])
    visited = [False for _ in range(n)]
    visited[n - 1] = True

    q = deque([n - 1])
    while q:
        cur = q.popleft()
        for next in path[cur]:
            if visited[next] or dist[next] >= dist[n - 1]: continue
            res.add(next + 1)
            visited[next] = True
            q.append(next)

    return res


T = int(input().strip())
for _ in range(T):
    n, m = map(int, input().strip().split())
    graph = [[] for _ in range(n)]
    path = [[] for _ in range(n)]

    for _ in range(m):
        f, t = map(int, input().strip().split())
        graph[f - 1].append(t - 1)

    dist = [n for _ in range(n)]
    dist[0] = 0
    bfs(graph, dist, path)

    ans = sorted(solve(n, dist, path))
    for i in ans:
        print(i, end=" ")
